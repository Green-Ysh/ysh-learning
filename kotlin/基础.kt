/* Kotlin 程序需要有一个 main 函数作为程序的入口点。 */
fun main() {
    println("Hello World!")
    basicTypes()
    operators()
    functions()
    conditions()
    nullSafety()
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

/* Kotlin 条件语句 */
fun conditions() {
    println("\n=== Kotlin 条件语句 ===")
    
    // 布尔表达式
    println("\n--- 布尔表达式 ---")
    val a = 5
    val b = 10
    
    // 布尔表达式-比较运算符: ==, !=, <, >, <=, >=
    println("a == b: ${a == b}")
    println("a != b: ${a != b}")
    println("a < b: ${a < b}")
    
    // 布尔表达式-逻辑运算符: &&(与), ||(或), !(非)
    println("a < 10 && b > 5: ${a < 10 && b > 5}")
    println("a > 10 || b > 5: ${a > 10 || b > 5}")
    println("!(a == b): ${!(a == b)}")
    
    // if/else 语句
    println("\n--- if/else 语句 ---")
    if (a < b) {
        println("a 小于 b")
    } else if (a > b) {
        println("a 大于 b")
    } else {
        println("a 等于 b")
    }
    
    // if/else 表达式 (返回值)
    println("\n--- if/else 表达式 ---")
    val max = if (a > b) {
        println("选择了 a")
        a  // 返回值
    } else {
        println("选择了 b")
        b  // 返回值
    }
    println("max = $max")
    
    // 单行 if/else 表达式
    val min = if (a < b) a else b
    println("min = $min")
    
    // when 语句
    println("\n--- when 语句 ---")
    val x = 3
    when (x) {
        1 -> println("x 等于 1")
        2 -> println("x 等于 2")
        3 -> println("x 等于 3")
        else -> println("x 不是 1, 2 或 3")
    }
    
    // when 表达式 (返回值)
    println("\n--- when 表达式 ---")
    val description = when (x) {
        1 -> "一"
        2 -> "二"
        3 -> {
            println("找到了 3!")
            "三"  // 返回值
        }
        else -> "其他数字"
    }
    println("x 的描述: $description")
    
    // 在 when 中使用逗号为多个分支定义相同行为
    println("\n--- when 使用逗号组合条件 ---")
    when (x) {
        1, 2 -> println("x 是 1 或 2")
        3, 4, 5 -> println("x 是 3, 4 或 5")
        else -> println("x 是其他数字")
    }
    
    // 在 when 中使用 in 范围
    println("\n--- when 使用 in 范围 ---")
    when (x) {
        in 1..5 -> println("x 在 1 到 5 的范围内")
        in 6..10 -> println("x 在 6 到 10 的范围内")
        !in 1..10 -> println("x 不在 1 到 10 的范围内")
        else -> println("以上条件都不满足")
    }
    
    // 在 when 中使用 is 关键字检查类型
    println("\n--- when 使用 is 关键字 ---")
    val obj: Any = "Hello"
    when (obj) {
        is String -> println("obj 是 String 类型，长度为 ${obj.length}")
        is Int -> println("obj 是 Int 类型，值为 $obj")
        is Boolean -> println("obj 是 Boolean 类型，值为 $obj")
        else -> println("obj 是其他类型")
    }
    
    // when 不带参数
    println("\n--- when 不带参数 ---")
    when {
        a > b -> println("a 大于 b")
        a < b -> println("a 小于 b")
        else -> println("a 等于 b")
    }
}

/* Kotlin null */
fun nullSafety() {
    println("\n=== Kotlin Null 安全 ===")
    
    // 什么是 null
    println("\n--- 什么是 null ---")
    // null 表示变量没有引用任何对象，即变量不指向内存中的任何位置
    // 在 Kotlin 中，默认情况下变量不能为 null，这是 Kotlin 的一个重要特性
    
    // 可为 null 类型与不可为 null 类型
    println("\n--- 可为 null 类型与不可为 null 类型 ---")
    // 不可为 null 类型（默认）
    var nonNullable: String = "Hello"
    // nonNullable = null // 编译错误：不能将 null 赋值给非空类型
    
    // 可为 null 类型（使用 ? 标记）
    var nullable: String? = "Hello"
    nullable = null // 正确：可以将 null 赋值给可空类型
    println("nullable = $nullable")
    
    // null 安全及其重要性
    println("\n--- null 安全及其重要性 ---")
    /*
     * null 安全是 Kotlin 的核心特性之一，它通过编译时检查来防止 NullPointerException (NPE)
     * 在 Java 等语言中，NPE 是最常见的运行时异常之一，可能导致程序崩溃
     * Kotlin 通过类型系统区分可为 null 和不可为 null 的类型，强制开发者处理 null 情况
     */
    
    // 安全调用运算符 ?.
    println("\n--- 安全调用运算符 ?. ---")
    val name: String? = "Kotlin"
    // 安全调用：如果 name 不为 null，则调用 length 属性；如果为 null，则整个表达式返回 null
    val length: Int? = name?.length
    println("name 的长度: $length")
    
    val nullName: String? = null
    val nullNameLength: Int? = nullName?.length // 返回 null 而不是抛出异常
    println("nullName 的长度: $nullNameLength")
    
    // 链式安全调用
    val employee: Employee? = Employee("John", Department("IT"))
    val departmentName: String? = employee?.department?.name
    println("部门名称: $departmentName")
    
    val nullEmployee: Employee? = null
    val nullDepartmentName: String? = nullEmployee?.department?.name // 整个表达式返回 null
    println("空员工的部门名称: $nullDepartmentName")
    
    // 非 null 断言运算符 !!
    println("\n--- 非 null 断言运算符 !! ---")
    /*
     * !! 运算符将任何值转换为非空类型，如果值为 null 则抛出异常
     * 使用 !! 时要小心，因为它可能导致 NullPointerException
     */
    val nonNullName: String = "Kotlin"
    val forcedLength: Int = nonNullName!!.length // 安全，因为 nonNullName 不为 null
    println("强制非空长度: $forcedLength")
    
    // 以下代码在运行时会抛出 NPE
    try {
        val nullString: String? = null
        // val willCrash: Int = nullString!!.length
        println("这行代码不会执行，因为上一行会抛出异常")
    } catch (e: Exception) {
        println("捕获到异常: ${e.javaClass.simpleName}")
    }
    
    // 使用 if/else 进行 null 检查
    println("\n--- 使用 if/else 进行 null 检查 ---")
    val nullableValue: String? = "Hello"
    
    if (nullableValue != null) {
        // 在这个作用域内，编译器知道 nullableValue 不为 null
        println("nullableValue 的长度: ${nullableValue.length}")
    } else {
        println("nullableValue 为 null")
    }
    
    // 使用 if/else 表达式将可为 null 的变量转换为不可为 null 类型
    println("\n--- 使用 if/else 表达式转换类型 ---")
    val nullableString: String? = "Kotlin"
    
    // 使用 if/else 表达式获取非空值或默认值
    val nonNullString: String = if (nullableString != null) nullableString else "默认值"
    println("非空字符串: $nonNullString")
    
    // Elvis 运算符 ?:
    println("\n--- Elvis 运算符 ?: ---")
    // Elvis 运算符是 if/else 表达式的简写形式，用于提供默认值
    val nullableStr: String? = null
    val result: String = nullableStr ?: "默认值" // 如果 nullableStr 为 null，则使用 "默认值"
    println("结果: $result")
    
    // Elvis 运算符的更复杂用法
    val length1 = name?.length ?: -1 // 如果 name 或 name.length 为 null，则返回 -1
    println("name 的长度或默认值: $length1")
    
    // Elvis 运算符与表达式结合
    val length2 = nullName?.length ?: run {
        println("警告: name 为 null")
        0 // 默认值
    }
    println("处理后的长度: $length2")
    
    // 安全转换 as?
    println("\n--- 安全转换 as? ---")
    val obj: Any = "Hello"
    val str: String? = obj as? String // 安全转换为 String，如果 obj 不是 String 则返回 null
    println("安全转换结果: $str")
    
    val num: Int? = obj as? Int // obj 不是 Int，所以返回 null
    println("不匹配类型的安全转换结果: $num")
    
    // let 与 null 安全
    println("\n--- let 与 null 安全 ---")
    nullable?.let {
        // 只有当 nullable 不为 null 时才执行这个代码块
        println("nullable 不为 null，值为: $it")
    }
    
    nullName?.let {
        println("这行不会执行，因为 nullName 为 null")
    } ?: println("nullName 为 null")
}

// 用于演示的辅助类
class Department(val name: String)
class Employee(val name: String, val department: Department?)
