/* Kotlin 程序需要有一个 main 函数作为程序的入口点。 */
fun main() {
    println("Hello World!")
    basicTypes()
    operators()
    functions()
    conditions()
    nullSafety()
    objectInstantiation()
    isARelationship()
    delegateProperties()
    mapDelegation()
    objectExpressions()
    // Singleton.display()
    // Singleton.increment()
    // Singleton.display()
    // println(MyClass.COMPANION_CONSTANT)
    // val myClass = MyClass.Companion.create()
    // Outer.Nested().display()
    // val outer2 = Outer2()
    // outer2.Inner().display()
    // println("Hello".addExclamation())
    // println("World".lastChar)
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

/* Kotlin 类和对象 */

// OOP 概览
/*
 * 面向对象编程 (OOP) 是一种编程范式，将数据和行为封装到对象中
 * Kotlin 是一种完全支持 OOP 的语言，同时也支持函数式编程
 * OOP 的四大核心概念：
 *   1. 封装：隐藏实现细节，只暴露必要的接口
 *   2. 继承：子类继承父类的属性和方法
 *   3. 多态：同一操作作用于不同的对象，产生不同的行为
 *   4. 抽象：抽象出共同特征，忽略非本质细节
 */

// 1. 什么是类？
/*
 * 类是创建对象的蓝图或模板，定义了对象的属性和行为
 * 在 Kotlin 中，类使用 class 关键字定义
 * 类包含：
 *   - 属性：存储数据
 *   - 方法：定义行为
 *   - 构造函数：初始化对象
 *   - 嵌套类和内部类：在类内部定义的类
 */

// 1.1 基本类定义
class SimpleClass {
    // 类体可以为空
}

// 1.2 带属性的类
class Person1 {
    var name: String = ""
    var age: Int = 0
}

// 1.3 带主构造函数的类
class Person2(val name: String, var age: Int) {
    // val 定义只读属性（有 getter 无 setter）
    // var 定义可变属性（有 getter 和 setter）
}

// 1.4 带初始化块的类
class Person3(val name: String, var age: Int) {
    // 初始化块在对象创建时执行
    init {
        println("初始化 Person3：$name, $age 岁")
        // 可以进行参数验证
        require(age >= 0) { "年龄必须是非负数" }
    }
    
    // 可以有多个初始化块，按顺序执行
    init {
        println("第二个初始化块")
    }
}

// 1.5 带次构造函数的类
class Person4(val name: String, var age: Int) {
    // 次构造函数必须直接或间接调用主构造函数
    constructor(name: String) : this(name, 0) {
        println("使用次构造函数创建，年龄默认为 0")
    }
    
    constructor() : this("未知") {
        println("使用无参构造函数创建")
    }
}

// 1.6 没有主构造函数的类
class Person5 {
    val name: String
    var age: Int
    
    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }
    
    constructor(name: String) {
        this.name = name
        this.age = 0
    }
}

// 1.7 带自定义访问器的属性
class Rectangle(val width: Int, val height: Int) {
    // 自定义 getter
    val area: Int
        get() = width * height
    
    // 自定义 getter 和 setter
    var displayName: String = "矩形"
        get() = "这是一个 $field"  // field 是幕后字段，引用属性本身
        set(value) {
            field = value.uppercase()  // 可以在 setter 中处理数据
        }
}

// 1.8 延迟初始化属性
class LateInitExample {
    // 使用 lateinit 延迟初始化非空属性
    lateinit var lateString: String
    
    fun initializeLateString() {
        lateString = "现在初始化"
    }
    
    fun checkIfInitialized() {
        if (::lateString.isInitialized) {
            println("lateString 已初始化: $lateString")
        } else {
            println("lateString 尚未初始化")
        }
    }
}

// 1.9 数据类
// 自动生成 equals(), hashCode(), toString(), copy() 和 componentN() 函数
data class User(val name: String, val age: Int)

// 1.10 枚举类
enum class Direction {
    NORTH, EAST, SOUTH, WEST
}

// 带属性和方法的枚举类
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF);
    
    fun containsRed(): Boolean = (rgb and 0xFF0000 != 0)
}

// 2. 如何实例化对象？
fun objectInstantiation() {
    // 2.1 基本实例化
    val person1 = Person1()
    person1.name = "张三"
    person1.age = 30
    
    // 2.2 使用主构造函数
    val person2 = Person2("李四", 25)
    
    // 2.3 使用次构造函数
    val person4a = Person4("王五")  // 使用带一个参数的次构造函数
    val person4b = Person4()  // 使用无参次构造函数
    
    // 2.4 使用数据类
    val user1 = User("赵六", 40)
    val user2 = user1.copy(age = 41)  // 复制并修改部分属性
    
    // 2.5 解构声明（仅适用于数据类或定义了 componentN 函数的类）
    val (name, age) = user1
    println("解构：$name, $age 岁")
    
    // 2.6 使用枚举
    val direction = Direction.NORTH
    val color = Color.RED
    println("颜色是否包含红色成分: ${color.containsRed()}")
}

// 3. 什么是继承？
/*
 * 继承是一种机制，允许一个类（子类）继承另一个类（父类）的属性和方法
 * 在 Kotlin 中：
 *   - 所有类默认是 final 的，不能被继承
 *   - 要允许一个类被继承，需要使用 open 关键字
 *   - 继承使用冒号 : 表示
 *   - Any 是所有类的超类（类似 Java 的 Object）
 */

// 3.1 基本继承
open class Animal(val name: String) {
    open fun makeSound() {
        println("动物发出声音")
    }
}

class Dog(name: String, val breed: String) : Animal(name) {
    override fun makeSound() {
        println("汪汪！")
    }
}

// 3.2 抽象类
abstract class Shape {
    abstract val area: Double  // 抽象属性
    abstract fun draw()  // 抽象方法
    
    // 非抽象方法
    fun display() {
        println("显示形状，面积: $area")
    }
}

class Circle(val radius: Double) : Shape() {
    override val area: Double
        get() = Math.PI * radius * radius
    
    override fun draw() {
        println("绘制圆形，半径: $radius")
    }
}

// 3.3 接口
interface Drawable {
    fun draw()  // 默认是抽象的
    val drawingTool: String  // 抽象属性
    
    // 带默认实现的方法
    fun displayInfo() {
        println("使用 $drawingTool 绘制")
    }
}

interface Colorable {
    val color: String
    fun applyColor()
}

// 实现多个接口
class Square(val side: Double) : Shape(), Drawable, Colorable {
    override val area: Double
        get() = side * side
    
    override fun draw() {
        println("绘制正方形，边长: $side")
    }
    
    override val drawingTool: String = "铅笔"
    
    override val color: String = "红色"
    
    override fun applyColor() {
        println("应用 $color 颜色到正方形")
    }
}

// 4. IS-A 关系和 HAS-A 关系
/*
 * IS-A 关系：通过继承实现，表示"是一种"关系
 * 例如：Dog IS-A Animal（狗是一种动物）
 * 
 * HAS-A 关系：通过组合实现，表示"有一个"关系
 * 例如：Car HAS-A Engine（汽车有一个引擎）
 */

// 4.1 IS-A 关系示例
fun isARelationship() {
    val dog = Dog("旺财", "金毛")
    val animal: Animal = dog  // 多态：子类对象可以赋值给父类引用
    
    animal.makeSound()  // 调用的是 Dog 的 makeSound 方法
    
    // 类型检查和转换
    if (animal is Dog) {
        println("这是一只 ${animal.breed} 犬")  // 智能转换
    }
}

// 4.2 HAS-A 关系示例
class Engine(val horsePower: Int) {
    fun start() {
        println("引擎启动，功率: ${horsePower}HP")
    }
}

class Car(val brand: String, val engine: Engine) {  // 组合关系
    fun start() {
        println("$brand 汽车启动")
        engine.start()
    }
}

// 5. 如何覆盖属性和函数？
/*
 * 在 Kotlin 中，要覆盖父类的属性或方法，需要：
 * 1. 父类的属性或方法标记为 open
 * 2. 子类的属性或方法标记为 override
 */

open class Base {
    open val prop: Int = 5  // 可覆盖属性
    open fun display() {  // 可覆盖方法
        println("Base display: $prop")
    }
    
    fun nonOverridable() {  // 不可覆盖方法（默认 final）
        println("不能被覆盖的方法")
    }
}

class Derived : Base() {
    override val prop: Int = 10  // 覆盖属性
    
    override fun display() {  // 覆盖方法
        println("Derived display: $prop")
        super.display()  // 调用父类方法
    }
}

// 6. 什么是可见性修饰符？
/*
 * Kotlin 提供四种可见性修饰符：
 * 1. public（默认）：可以在任何地方访问
 * 2. private：只在类内部可见
 * 3. protected：在类及其子类中可见
 * 4. internal：在同一模块内可见
 */

open class VisibilityDemo {
    public val publicProp = "公共属性"  // 默认是 public，可以省略
    private val privateProp = "私有属性"  // 只在类内部可见
    protected val protectedProp = "受保护属性"  // 在类及其子类中可见
    internal val internalProp = "内部属性"  // 在同一模块内可见
    
    fun accessProps() {
        println(publicProp)  // 可以访问
        println(privateProp)  // 可以访问
        println(protectedProp)  // 可以访问
        println(internalProp)  // 可以访问
    }
}

class VisibilityChild : VisibilityDemo() {
    fun accessParentProps() {
        println(publicProp)  // 可以访问
        // println(privateProp)  // 错误：无法访问
        println(protectedProp)  // 可以访问
        println(internalProp)  // 可以访问
    }
}

// 7. 对象表达式和对象声明
// 7.1 对象表达式（匿名内部类）
fun objectExpressions() {
    // 创建一个匿名类的实例
    val listener = object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            println("鼠标点击: (${e.x}, ${e.y})")
        }
        
        override fun mouseEntered(e: MouseEvent) {
            println("鼠标进入")
        }
    }
    
    // 不需要继承任何类的匿名对象
    val anonymousObject = object {
        var x: Int = 0
        var y: Int = 0
        
        fun printCoordinates() {
            println("坐标: ($x, $y)")
        }
    }
    
    anonymousObject.x = 10
    anonymousObject.y = 20
    anonymousObject.printCoordinates()
}

// 7.2 对象声明（单例）
object Singleton {
    var count: Int = 0
    
    fun increment() {
        count++
    }
    
    fun display() {
        println("计数: $count")
    }
}

// 7.3 伴生对象（类似于静态成员）
class MyClass {
    companion object {
        const val CONSTANT = "常量值"
        
        fun create(): MyClass = MyClass()
    }
}

// 8. 嵌套类和内部类
// 8.1 嵌套类（不持有外部类引用）
class Outer {
    private val outerProperty = "外部属性"
    
    class Nested {
        fun display() {
            // 无法访问 outerProperty
            println("这是嵌套类")
        }
    }
}

// 8.2 内部类（持有外部类引用）
class Outer2 {
    private val outerProperty = "外部属性"
    
    inner class Inner {
        fun display() {
            // 可以访问外部类的属性
            println("内部类可以访问: $outerProperty")
            println("也可以使用 this@Outer2: ${this@Outer2.outerProperty}")
        }
    }
}

// 9. 扩展函数和属性
// 9.1 扩展函数
fun String.addExclamation(): String {
    return this + "!"
}

// 9.2 扩展属性
val String.lastChar: Char
    get() = this[length - 1]

// 导入 Kotlin 标准库中的委托
import kotlin.properties.Delegates
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import kotlin.reflect.KProperty

// 7. 什么是委托以及如何使用 by 委托？
/*
 * 委托是一种设计模式，它允许一个对象将特定任务委托给另一个辅助对象
 * Kotlin 使用 by 关键字原生支持委托模式
 */

// 7.1 接口委托
interface Base2 {
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl(val x: Int) : Base2 {
    override fun printMessage() {
        print(x)
    }
    
    override fun printMessageLine() {
        println(x)
    }
}

// 使用 by 关键字委托给另一个对象
class Derived2(b: Base2) : Base2 by b {
    // 可以选择性地覆盖某些方法
    override fun printMessage() {
        print("abc")
    }
}

// 7.2 属性委托
// 标准库中的委托
fun delegateProperties() {
    // lazy 委托：第一次访问时初始化
    val lazyValue: String by lazy {
        println("计算 lazyValue...")
        "Hello, Lazy!"
    }
    
    println("lazyValue 初始化前...")
    println("lazyValue = $lazyValue")  // 第一次访问，会计算值
    println("lazyValue = $lazyValue")  // 第二次访问，使用缓存的值
    
    // observable 委托：属性变化时通知
    var observableProp: String by Delegates.observable("初始值") { prop, old, new ->
        println("属性 ${prop.name} 从 '$old' 变为 '$new'")
    }
    
    observableProp = "新值 1"
    observableProp = "新值 2"
    
    // vetoable 委托：可以否决属性变化
    var vetoableProp: Int by Delegates.vetoable(0) { prop, old, new ->
        new > old  // 只允许值增加
    }
    
    vetoableProp = 10  // 设置成功
    println("vetoableProp = $vetoableProp")  // 输出 10
    
    vetoableProp = 5  // 设置失败（5 < 10）
    println("vetoableProp = $vetoableProp")  // 仍然是 10
}

// 7.3 自定义委托
class MyDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, 属性名: '${property.name}'"
    }
    
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef 的 '${property.name}' 设置为 $value")
    }
}

class DelegateUser {
    var name: String by MyDelegate()
}

// 7.4 Map 委托
fun mapDelegation() {
    val map = mapOf(
        "name" to "张三",
        "age" to 30
    )
    
    // 将 map 的键值对委托给属性
    val user = object {
        val name: String by map
        val age: Int by map
    }
    
    println("name = ${user.name}, age = ${user.age}")
}
