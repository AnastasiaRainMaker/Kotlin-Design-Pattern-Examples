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

class ShapeDrawer(private val _shape: CustomShape) {

    private val _blueAndBigTransformator by lazy {
        ColorTransformer(
            "BLUE",
            SizeTransformer("BIG")
        )
    }

    fun makeBlueAndBig() {
        _blueAndBigTransformator.transform(_shape)
    }
}

