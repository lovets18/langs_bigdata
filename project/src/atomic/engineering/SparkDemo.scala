package atomic.engineering

import org.apache.spark.sql.SparkSession

object SparkDemo {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[1]").appName("AtomicEngineering").getOrCreate()

    println("name:" + spark.sparkContext.appName)
    val path = "src/russian_air_service_CARGO_AND_PARCELS.csv"
    val df = spark.read.option("header", "true").csv(path)
//    df.show()


    df.createOrReplaceTempView("data")

    var sqlDF = spark.sql("SELECT * FROM data limit 10")
    sqlDF.show()

    sqlDF.printSchema

    sqlDF = spark.sql("SELECT COUNT(*) AS row_count FROM data")
    sqlDF.show()

    sqlDF = spark.sql("SELECT DISTINCT Year FROM data")
    sqlDF.show()

    sqlDF = spark.sql("SELECT * FROM data WHERE `Airport name` LIKE 'B%'")
    sqlDF.show()

    sqlDF = spark.sql("SELECT `Airport name`, Year FROM data LIMIT 10")
    sqlDF.show()

    sqlDF = spark.sql("SELECT * FROM data WHERE February > 600")
    sqlDF.show()

    sqlDF = spark.sql("SELECT Year, SUM(September) AS total FROM data GROUP BY Year")
    sqlDF.show()

    sqlDF = spark.sql("SELECT * FROM data ORDER BY June DESC limit 10")
    sqlDF.show()

    sqlDF = spark.sql("SELECT AVG(October) AS average, MAX(October) AS maximum FROM data")
    sqlDF.show()

    sqlDF = spark.sql("SELECT COUNT(DISTINCT `Airport name`) AS airports FROM data")
    sqlDF.show()

    sqlDF = spark.sql("SELECT `Airport name`, SUM(December) AS total_load FROM data GROUP BY `Airport name` ORDER BY total_load DESC LIMIT 10")
    sqlDF.show()
    spark.stop()
  }
}