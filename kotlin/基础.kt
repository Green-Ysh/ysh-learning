/* Kotlin 程序需要有一个 main 函数作为程序的入口点。 */
fun main() {
    println("Hello World!")
    basicTypes()
    operators()
    functions()
}

/* Kotlin 基本类型 */
fun basicTypes() {
    // var val
    // var 可变 val 不可变

    // 1. 数字类型
    // 整数类型
    val byte: Byte = 127                // 8位
    val short: Short = 32767            // 16位
    val int: Int = 2147483647           // 32位
    val long: Long = 9223372036854775807L // 64位

    // 浮点数类型
    val float: Float = 3.14f            // 32位
    val double: Double = 3.14159        // 64位

    println("Number types:")
    println("Byte: $byte")
    println("Short: $short")
    println("Int: $int")
    println("Long: $long")
    println("Float: $float")
    println("Double: $double")

    // 2. 字符类型
    val char: Char = 'A'
    println("Character types:")
    println("Char: $char")

    // 3. 布尔类型
    val boolean: Boolean = true
    println("Boolean types:")
    println("Boolean: $boolean")

    // 4. 字符串类型
    val string: String = "Hello Kotlin"
    // 多行字符串 支持保留格式，不需要转义字符
    val multiLineString = """
        This is a multi-line string
        Format is preserved
        No escape characters needed
    """.trimIndent()
    
    println("String types:")
    println("String: $string")
    println("Multi-line string: $multiLineString")

    // 5. 数组
    val intArray = IntArray(3) { it * 2 }  // [0, 2, 4]
    val stringArray = Array(3) { "Item ${it + 1}" }
    
    println("Array types:")
    println("Int array: ${intArray.joinToString()}")
    println("String array: ${stringArray.joinToString()}")

    // 6. 类型转换
    val intValue = 100
    val longValue = intValue.toLong()
    val doubleValue = intValue.toDouble()
    
    println("Type conversion:")
    println("Int to Long: $longValue")
    println("Int to Double: $doubleValue")

    // 7. 空值处理
    val nullableString: String? = null
    val length = nullableString?.length ?: 0  // 使用安全调用操作符和Elvis操作符
    
    println("Null value handling:")
    println("Nullable string length: $length")
}

/* Kotlin 运算符 */
fun operators() {
    // 1. 算术运算符
    val a = 10
    val b = 3
    
    println("Arithmetic Operators:")
    println("a + b = ${a + b}")    // 加法
    println("a - b = ${a - b}")    // 减法
    println("a * b = ${a * b}")    // 乘法
    println("a / b = ${a / b}")    // 除法
    println("a % b = ${a % b}")    // 取余
    
    // 2. 比较运算符
    println("\nComparison Operators:")
    println("a > b: ${a > b}")     // 大于
    println("a < b: ${a < b}")     // 小于
    println("a >= b: ${a >= b}")   // 大于等于
    println("a <= b: ${a <= b}")   // 小于等于
    println("a == b: ${a == b}")   // 等于
    println("a != b: ${a != b}")   // 不等于
    
    // 3. 赋值运算符
    var x = 5
    println("\nAssignment Operators:")
    println("x = $x")
    x += 3                         // 相当于 x = x + 3
    println("x += 3: $x")
    x -= 2                         // 相当于 x = x - 2
    println("x -= 2: $x")
    x *= 2                         // 相当于 x = x * 2
    println("x *= 2: $x")
    
    // 4. 递增递减
    println("\nIncrement/Decrement:")
    println("x++: ${x++}")         // 后缀递增
    println("Current x: $x")
    println("++x: ${++x}")         // 前缀递增
    println("x--: ${x--}")         // 后缀递减
    println("--x: ${--x}")         // 前缀递减
    
    // 5. 逻辑运算符
    val p = true
    val q = false
    println("\nLogical Operators:")
    println("p && q: ${p && q}")   // 与
    println("p || q: ${p || q}")   // 或
    println("!p: ${!p}")           // 非
}

/* Kotlin 创建和使用函数 */
fun functions() {
    // 基本函数定义 - 显式声明 Unit 返回类型
    fun sayHello(): Unit {
        println("Hello from Kotlin!")
    }

    // 基本函数定义 - 省略 Unit 返回类型（默认）
    fun sayGoodbye() {  // 等同于 fun sayGoodbye(): Unit
        println("Goodbye from Kotlin!")
    }

    // 带参数的函数
    fun greet(name: String) {
        println("Hello, $name!")
    }

    // 带返回值的函数
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    // 单表达式函数
    fun multiply(x: Int, y: Int) = x * y

    // 带默认参数的函数
    fun greetWithTitle(name: String, title: String = "Mr.") {
        println("Hello, $title $name")
    }

    // 可变参数函数
    fun sumAll(vararg numbers: Int): Int {
        return numbers.sum()
    }

    // 调用函数示例
    sayHello()
    sayGoodbye()
    greet("Alice")
    println("Sum: ${sum(5, 3)}")
    println("Multiply: ${multiply(4, 2)}")
    greetWithTitle("Bob")
    greetWithTitle("Alice", "Ms.")
    println("Sum of numbers: ${sumAll(1, 2, 3, 4, 5)}")
}
