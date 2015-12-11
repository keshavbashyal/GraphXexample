
import java.util.Arrays

import org.nd4j.api.linalg.DSL._
import org.nd4j.linalg.api.ndarray.INDArray
import org.nd4j.linalg.factory.Nd4j
import org.nd4j.linalg.indexing.{NDArrayIndex, BooleanIndexing}
import org.nd4j.linalg.indexing.conditions.Conditions
import org.nd4j.linalg.indexing.functions.Value
import org.nd4j.linalg.ops.transforms.Transforms._



/**
 * Examples of Scala Nd4j usage
 *
 * Before using Scala Nd4j, make sure you have included the nd4j-scala-api Maven dependency
 * Ensure you have the Scala plugin (IntelliJ: Preferences -> Plugins)
 * Add Maven Scala plugin and plugin repository to pom.xml
 *
 *
 * @author sonali
 */
object Nd4jScalaExamples {

  def main (args: Array[String]) {
    /** Creating arrays in multiple ways, all using numpy syntax */
    var arr = Nd4j.create(4)
    var arr2 = Nd4j.ones(4)
    val arr3 = Nd4j.linspace(1, 10, 10)
    val arr4 = Nd4j.linspace(1, 6, 6).reshape(2, 3)

    /** Array addition in place */
    arr += arr2
    arr += 2

    /** Array multiplication in place */
    arr2 *= 5

    /** Transpose matrix */
    val arrT = arr.T

    /** Row (1) and Column (0) Sums */
    println(Nd4j.sum(arr4, 0).toString + "Calculate the sum for each column")
    println(Nd4j.sum(arr4, 1).toString + "Calculate the sum for each row")

    /** Checking array shape */
    println(Arrays.toString(arr2.shape) + "Checking array shape")

    /** Converting array to a string */
    println(arr2.toString() + "Array converted to string")

    /** Filling the array with the value 5 (same as numpy's fill method) */
    println(arr2.assign(5).toString + "Array assigned value of 5 (equivalent to fill method in numpy)")

    /** Reshaping the array */
    println(arr2.reshape(2, 2).toString + "Reshaping array")

    /** Raveling the array (returns a flattened array) */
    println(arr2.ravel.toString + "Raveling array")

    /** Flattening the array (same as numpy's flatten method) */
    println(Nd4j.toFlattened(arr2).toString + "Flattening array (equivalent to flatten in numpy)")

    /** Array sorting */
    println(Nd4j.sort(arr2, 0, true).toString + "Sorting array")
    println(Nd4j.sortWithIndices(arr2, 0, true).toString + "Sorting array and returning sorted indices")

    /** Cumulative sum */
    println(Nd4j.cumsum(arr2).toString + "Cumulative sum")

    /** Basic stats methods */
    println(Nd4j.mean(arr).toString + "Calculate mean of array")
    println(Nd4j.std(arr2).toString + "Calculate standard deviation of array")
    println(Nd4j.`var`(arr2).toString, "Calculate variance")

    /** Find min and max values */
    println(Nd4j.max(arr3), "Find max value in array")
    println(Nd4j.min(arr3), "Find min value in array")

    /** Boolean indexing */
    /** Where a given condition holds true, apply a function to an NDArray */
    /** In this example, replace any values below 5 with 5 */
    BooleanIndexing.applyWhere(arr3, Conditions.lessThan(5), new Value(5))

    /** In this example, replace any NaN values with 0 */
    BooleanIndexing.applyWhere(arr3, Conditions.isNan, new Value(0))

    /** Use .and for conditions that must be true for all elements in the array */
    if (BooleanIndexing.and(arr3, Conditions.greaterThan(0))) {
      println("All elements in array are greater than 0.")
    }

    /** Use .or for conditions that must be true for AT LEAST one element in the array */
    if (BooleanIndexing.or(arr3, Conditions.lessThanOrEqual(5))) {
      println("At least one element in array is less than or equal to 5.")
    }

    /** Use NDArrayIndex for indexing/slicing an array */
    val arr3Slice: INDArray = arr3.get(NDArrayIndex.interval(1, 5))

  }

}