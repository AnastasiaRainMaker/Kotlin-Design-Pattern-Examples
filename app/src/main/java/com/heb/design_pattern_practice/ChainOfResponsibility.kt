package com.heb.design_pattern_practice

interface ChainTransformation {
    fun transform(shape: CustomShape): CustomShape
}

class ColorTransformer(private val color: String, val next: ChainTransformation? = null) :
    ChainTransformation {

    override fun transform(shape: CustomShape): CustomShape {
        shape.color = color
        next?.transform(shape)
        return shape
    }
}

data class CustomShape(var color: String, var size: String)

class SizeTransformer(private val size: String, val next: ChainTransformation? = null) :
    ChainTransformation {

    override fun transform(shape: CustomShape): CustomShape {
        shape.size = size
        next?.transform(shape)
        return shape
    }
}

class ShapeDrawer(private val shape: CustomShape) {

    private val blueAndBigTransformator by lazy {
        ColorTransformer(
            "BLUE",
            next = SizeTransformer("BIG")
        )
    }

    fun makeBlueAndBig() {
        blueAndBigTransformator.transform(shape)
    }
}

fun main() {
    val shape = CustomShape(color = "YELLOW", size = "SMALL")
    val shapeDrawer = ShapeDrawer(shape)
    shapeDrawer.makeBlueAndBig()
    println(shape)

    //result
    //CustomShape(color=BLUE, size=BIG)
}

