package com.heb.design_pattern_practice

interface VisitableReport {
    fun <R> accept(visitor: ReportVisitor<R>): R
}

class MonthlyReport(val totalSales: Long) : VisitableReport {

    override fun <R> accept(visitor: ReportVisitor<R>): R = visitor.visit(this)
}

class YearlyReport(val totalSales: Long) : VisitableReport {

    override fun <R> accept(visitor: ReportVisitor<R>): R = visitor.visit(this)
}

interface ReportVisitor<out R> {
    fun visit(report: MonthlyReport): R
    fun visit(report: YearlyReport): R
}

class TotalSalesReporter : ReportVisitor<Long> {
    override fun visit(report: MonthlyReport): Long =
        report.totalSales / COMPANY_IN_BUSINESS / 12

    override fun visit(report: YearlyReport): Long =
        report.totalSales / COMPANY_IN_BUSINESS

}

class CompanyPerformanceAnalyzer {

    private val _totalSales: Long = 100_000

    private val _totalSalesReporter = TotalSalesReporter()

    fun calculateMonthlySales(): Long =
        MonthlyReport(_totalSales).accept(_totalSalesReporter)

    fun calculateYearlySales(): Long =
        YearlyReport(_totalSales).accept(_totalSalesReporter)

}

const val COMPANY_IN_BUSINESS = 3