/* Kotlin 类和对象 - 系统化学习笔记 */

/**
 * Kotlin 面向对象编程学习指南
 * 
 * 本文件系统地介绍了 Kotlin 中的类和对象相关概念，从基础到高级，
 * 适合初学者逐步学习。每个部分都包含详细的代码示例和解释。
 * 
 * 面向对象编程（OOP）是一种编程范式，它将数据和行为封装到对象中。
 * Kotlin 作为一种现代编程语言，完全支持面向对象编程，并提供了许多
 * 便捷的特性使得代码更加简洁、安全和易于维护。
 * 
 * 学习建议：
 * 1. 按顺序阅读和运行代码，理解每个概念
 * 2. 尝试修改示例代码，观察结果变化
 * 3. 完成一部分后，尝试自己编写类似的代码巩固知识
 */

fun main() {
    println("=== Kotlin 类和对象学习笔记 ===")
    
    // 依次调用各部分示例函数
    classBasics()
    constructors()
    properties()
    methods()
    dataClasses()
    enumsAndSealedClasses()
    objectInstantiation()
    inheritance()
    abstraction()
    interfaces()
    polymorphism()
    visibilityModifiers()
    objectExpressions()
    nestedAndInnerClasses()
    extensionFunctions()
    delegation()
}

/**
 * 第1部分：类的基础知识
 * 
 * 类是面向对象编程的基本单元，它是创建对象的模板或蓝图。
 * 类定义了对象的属性（数据）和方法（行为）。
 * 
 * 在 Kotlin 中，类使用 class 关键字定义，最简单的类可以没有任何内容。
 * 
 * 类与对象的关系：
 * - 类是定义，对象是实例
 * - 类似于建筑图纸和实际建筑的关系
 * - 一个类可以创建多个对象
 */
fun classBasics() {
    println("\n=== 1. 类的基础知识 ===")
    
    // 1.1 基本类定义
    println("\n--- 1.1 基本类定义 ---")
    // 使用类名加括号创建类的实例（对象）
    val simpleClass = SimpleClass()  // 创建类的实例（对象）
    println("创建了一个简单类的实例: $simpleClass")  // 输出对象的字符串表示
    
    // 1.2 带属性的类
    println("\n--- 1.2 带属性的类 ---")
    val person = Person1()  // 创建 Person1 类的实例
    person.name = "张三"    // 设置属性值，使用点语法访问属性
    person.age = 30
    person.introduce()     // 调用对象的方法
    
    // 1.3 带方法的类
    println("\n--- 1.3 带方法的类 ---")
    person.celebrateBirthday()  // 调用另一个方法，模拟过生日
}

/**
 * 1.1 基本类定义
 * 
 * 这是最简单的类定义，没有任何属性或方法。
 * 即使没有显式定义构造函数，Kotlin 也会提供一个无参数的默认构造函数。
 * 
 * 在实际开发中，空类很少使用，通常会包含属性和方法。
 */
class SimpleClass {
    // 空类，没有任何属性或方法
    // 这样的类在实际开发中很少使用，通常用于演示或作为占位符
}

/**
 * 1.2 带属性的类
 * 
 * 类的主要作用是封装数据（属性）和行为（方法）。
 * 属性用于存储对象的状态信息。
 * 
 * Kotlin 中的属性可以是：
 * - var：可变属性，可以修改值
 * - val：不可变属性（只读），初始化后不能修改
 * - 可以有默认值或延迟初始化
 * - 可以是可空类型（使用 ? 标记）
 */
class Person1 {
    // 属性（成员变量）
    var name: String = ""  // 可变属性，有默认值
    var age: Int = 0       // 可变属性，有默认值
    var email: String? = null  // 可空属性，可以存储 null 值
    
    /**
     * 方法（成员函数）用于定义对象的行为
     * 这个方法用于介绍人物信息
     * 
     * 在 Kotlin 中，方法使用 fun 关键字定义
     */
    fun introduce() {
        println("大家好，我是 $name，今年 $age 岁")
    }
    
    /**
     * 成员函数可以访问类的所有属性
     * 这个方法模拟过生日，年龄增加
     * 
     * 方法可以修改类的属性，实现对象状态的变化
     */
    fun celebrateBirthday() {
        age++  // 增加年龄
        println("$name 过生日了，现在 $age 岁了")
    }
}

/**
 * 第2部分：构造函数
 * 
 * 构造函数用于初始化类的新实例（对象）。
 * Kotlin 中有主构造函数和次构造函数两种：
 * 
 * 1. 主构造函数：
 *    - 是类头的一部分，在类名后面用括号声明
 *    - 可以包含参数，这些参数可以在类体中使用
 *    - 可以使用 val/var 直接声明为属性
 * 
 * 2. 次构造函数：
 *    - 使用 constructor 关键字在类体内定义
 *    - 如果类有主构造函数，每个次构造函数需要直接或间接地委托给它
 *    - 可以有多个次构造函数，提供不同的初始化方式
 */
fun constructors() {
    println("\n=== 2. 构造函数 ===")
    
    // 2.1 主构造函数
    println("\n--- 2.1 主构造函数 ---")
    val person2 = Person2("李四", 25)
    person2.email = "lisi@example.com"
    person2.introduce()
    
    // 2.2 带初始化块的类
    println("\n--- 2.2 带初始化块的类 ---")
    val person3 = Person3("王五", 35)
    
    // 2.3 次构造函数
    println("\n--- 2.3 次构造函数 ---")
    val person4a = Person4("赵六")  // 使用带一个参数的次构造函数
    val person4b = Person4()  // 使用无参次构造函数
    val person4c = Person4("钱七", 40, "qianqi@example.com")  // 使用带三个参数的次构造函数
    
    // 2.4 没有主构造函数的类
    println("\n--- 2.4 没有主构造函数的类 ---")
    val person5 = Person5("孙八", 45)
    person5.introduce()
}

/**
 * 2.1 主构造函数
 * 
 * 主构造函数是类头的一部分，在类名后面用括号声明。
 * 主构造函数的参数可以直接声明为属性，使用 val 或 var 关键字。
 * 
 * 使用 val 声明的属性是只读的（不可变），只能赋值一次。
 * 使用 var 声明的属性是可读写的（可变），可以多次赋值。
 * 
 * @param name 人名
 * @param age 年龄
 */
class Person2(val name: String, var age: Int) {
    // 主构造函数中的参数可以直接声明为属性
    // val name: 不可变属性（只读），不能被重新赋值
    // var age: 可变属性（可读可写），可以被修改
    
    // 额外的属性，不在构造函数中初始化
    var email: String = ""
    
    /**
     * 方法可以访问所有属性，包括构造函数中定义的属性
     */
    fun introduce() {
        println("我是 $name，今年 $age 岁，邮箱是 $email")
    }
}

/**
 * 2.2 带初始化块的类
 * 
 * 初始化块（init 块）在构造实例时执行，用于初始化逻辑。
 * 可以有多个初始化块，按照它们在类中的顺序执行。
 * 
 * 初始化块的主要用途：
 * - 执行复杂的初始化逻辑
 * - 验证构造函数参数
 * - 初始化需要计算的属性
 * 
 * @param name 人名
 * @param age 年龄
 */
class Person3(val name: String, val age: Int) {
    // 需要在初始化块中赋值的属性
    val adult: Boolean  // 是否成年
    val profile: String // 个人简介
    
    /**
     * 初始化块 - 在构造实例时执行
     * 可以使用构造函数的参数
     * 
     * 所有的初始化块和属性初始化器都按照它们在类中出现的顺序执行
     */
    init {
        println("正在创建 Person3 实例...")
        adult = age >= 18  // 根据年龄判断是否成年
        profile = "$name, $age 岁, ${if (adult) "成年人" else "未成年人"}"
        println("创建完成: $profile")
    }
    
    /**
     * 可以有多个初始化块，按顺序执行
     * 这在需要分组初始化逻辑时很有用
     */
    init {
        println("第二个初始化块执行")
    }
}

/**
 * 2.3 带次构造函数的类
 * 
 * 次构造函数使用 constructor 关键字定义。
 * 如果类有主构造函数，每个次构造函数需要直接或间接地委托给它。
 * 
 * 次构造函数的主要用途：
 * - 提供多种创建对象的方式
 * - 设置不同的默认值
 * - 实现不同的初始化逻辑
 * 
 * @param name 人名
 * @param age 年龄
 * @param email 电子邮箱
 */
class Person4(val name: String, var age: Int, var email: String) {
    // 额外的属性
    var address: String = ""
    
    /**
     * 次构造函数 - 只有名字参数
     * 使用 this 关键字委托给主构造函数
     * 
     * 委托格式：constructor(...) : this(...) { ... }
     */
    constructor(name: String) : this(name, 0, "") {
        println("使用只有名字的次构造函数")
    }
    
    /**
     * 次构造函数 - 无参数
     * 通过委托给另一个次构造函数，间接委托给主构造函数
     */
    constructor() : this("未知", 0, "") {
        println("使用无参数的次构造函数")
    }
    
    /**
     * 次构造函数 - 带地址参数
     * 先调用主构造函数，然后执行自己的初始化代码
     */
    constructor(name: String, age: Int, email: String, address: String) : this(name, age, email) {
        this.address = address
        println("使用带地址的次构造函数")
    }
}

/**
 * 2.4 没有主构造函数的类
 * 
 * 如果类没有主构造函数，则每个次构造函数必须初始化类的属性。
 * 这种情况下，次构造函数不需要使用 this 委托。
 * 
 * 这种方式在以下情况下有用：
 * - 需要多种完全不同的初始化方式
 * - 从旧代码迁移过来，保持兼容性
 * - 实现特定的设计模式
 */
class Person5 {
    // 属性声明
    val name: String  // 必须在构造函数中初始化
    var age: Int      // 必须在构造函数中初始化
    
    /**
     * 次构造函数
     * 如果没有主构造函数，次构造函数必须初始化所有未初始化的属性
     */
    constructor(name: String, age: Int) {
        this.name = name  // 使用 this 关键字区分属性和参数
        this.age = age
        println("Person5 构造函数被调用")
    }
    
    /**
     * 方法定义
     */
    fun introduce() {
        println("Person5: 我是 $name，今年 $age 岁")
    }
}

/**
 * 第3部分：属性
 * 
 * Kotlin 中的属性是类的重要组成部分，用于存储对象的状态。
 * Kotlin 的属性比 Java 的字段更强大，它们可以有自定义的访问器（getter 和 setter）。
 * 
 * Kotlin 属性的特点：
 * 1. 默认实现了 getter 和 setter（对于 var 属性）
 * 2. 可以自定义 getter 和 setter
 * 3. 支持延迟初始化（lateinit）
 * 4. 支持委托属性
 * 5. 可以使用 const 声明编译时常量
 */
fun properties() {
    println("\n=== 3. 属性 ===")
    
    // 3.1 基本属性访问
    println("\n--- 3.1 基本属性访问 ---")
    val person = PropertyDemo()
    println("姓名: ${person.name}")
    println("年龄: ${person.age}")
    person.age = 30  // 调用 setter
    println("修改后年龄: ${person.age}")  // 调用 getter
    
    // 3.2 自定义访问器
    println("\n--- 3.2 自定义访问器 ---")
    println("全名: ${person.fullName}")  // 调用自定义 getter
    person.fullName = "王大锤"  // 调用自定义 setter
    println("修改后姓名: ${person.firstName} ${person.lastName}")
    
    // 3.3 计算属性
    println("\n--- 3.3 计算属性 ---")
    println("是否成年: ${person.isAdult}")  // 计算属性
    
    // 3.4 后备字段
    println("\n--- 3.4 后备字段 ---")
    println("分数: ${person.score}")
    person.score = 95
    println("修改后分数: ${person.score}")
    
    // 3.5 常量
    println("\n--- 3.5 常量 ---")
    println("最大年龄: ${PropertyDemo.MAX_AGE}")
    
    // 3.6 延迟初始化属性
    println("\n--- 3.6 延迟初始化属性 ---")
    val lateInitExample = LateInitExample()
    // println(lateInitExample.lateProperty) // 这会抛出异常
    lateInitExample.initializeLateProperty("已初始化的值")
    println("延迟初始化属性: ${lateInitExample.lateProperty}")
    
    // 3.7 非空属性必须初始化
    println("\n--- 3.7 非空属性必须初始化 ---")
    val nonNullExample = NonNullPropertyExample("初始值")
    println("非空属性: ${nonNullExample.nonNullProperty}")
}

/**
 * 属性演示类
 * 
 * 这个类展示了 Kotlin 中各种属性的用法
 */
class PropertyDemo {
    // 3.1 基本属性
    var name: String = "张三"  // 可变属性，默认有 getter 和 setter
    var age: Int = 25         // 可变属性
    
    // 姓和名
    var firstName: String = "张"
    var lastName: String = "三"
    
    /**
     * 3.2 自定义访问器
     * 
     * 自定义 getter 和 setter 允许在读取或修改属性时执行自定义逻辑
     * - getter: 在读取属性值时调用
     * - setter: 在设置属性值时调用
     */
    var fullName: String
        // 自定义 getter - 当读取 fullName 属性时调用
        get() = "$firstName $lastName"
        // 自定义 setter - 当设置 fullName 属性时调用
        set(value) {
            println("设置全名: $value")
            // 拆分全名为姓和名
            val parts = value.split(" ")
            if (parts.size == 2) {
                firstName = parts[0]
                lastName = parts[1]
            } else {
                println("全名格式不正确，应为'姓 名'格式")
            }
        }
    
    /**
     * 3.3 计算属性
     * 
     * 计算属性没有存储值，而是在每次访问时计算结果
     * 只有 getter 的属性通常用于派生值
     */
    val isAdult: Boolean
        get() = age >= 18
    
    /**
     * 3.4 使用后备字段的属性
     * 
     * 后备字段（backing field）用于在自定义访问器中引用属性本身
     * 使用 field 关键字访问
     * 
     * 只有当属性需要自定义访问器且访问器引用属性本身时，才会生成后备字段
     */
    var score: Int = 0
        get() {
            println("获取分数")
            return field  // 使用 field 关键字引用后备字段
        }
        set(value) {
            println("设置分数为 $value")
            // 验证分数范围
            field = when {
                value < 0 -> 0
                value > 100 -> 100
                else -> value
            }
        }
    
    /**
     * 3.5 伴生对象中的常量
     * 
     * 使用 const 关键字声明编译时常量
     * 只能用于基本类型和 String
     */
    companion object {
        const val MAX_AGE = 150  // 编译时常量
    }
}

/**
 * 3.6 延迟初始化属性
 * 
 * lateinit 修饰符允许在声明非空属性的同时，延迟它的初始化
 * 
 * 使用场景：
 * - 依赖注入
 * - 在 Android 中初始化视图
 * - 单元测试的 setUp 方法中
 * 
 * 限制：
 * - 只能用于 var 属性
 * - 不能用于基本类型（Int, Boolean 等）
 * - 在初始化前访问会抛出异常
 */
class LateInitExample {
    // 使用 lateinit 关键字声明延迟初始化属性
    lateinit var lateProperty: String
    
    /**
     * 初始化延迟属性的方法
     */
    fun initializeLateProperty(value: String) {
        lateProperty = value
    }
    
    /**
     * 检查延迟属性是否已初始化
     * 
     * 使用 ::属性名.isInitialized 检查
     */
    fun checkIfInitialized(): Boolean {
        return ::lateProperty.isInitialized
    }
}

/**
 * 3.7 非空属性必须初始化
 * 
 * Kotlin 的类型系统强制非空属性必须初始化
 * 可以在声明时、构造函数中或初始化块中初始化
 */
class NonNullPropertyExample(initialValue: String) {
    // 非空属性必须初始化
    val nonNullProperty: String = initialValue
    
    // 也可以在初始化块中初始化
    val computedProperty: String
    
    init {
        computedProperty = "计算得到的值: ${initialValue.length}"
    }
}

/**
 * 第4部分：方法
 * 
 * 方法是类中定义的函数，用于实现对象的行为。
 * Kotlin 中的方法使用 fun 关键字定义，可以有参数、返回值和泛型。
 * 
 * Kotlin 方法的特点：
 * 1. 简洁的语法
 * 2. 默认参数和命名参数
 * 3. 单表达式函数
 * 4. 扩展函数
 * 5. 中缀表示法
 * 6. 操作符重载
 */
fun methods() {
    println("\n=== 4. 方法 ===")
    
    // 4.1 基本方法
    println("\n--- 4.1 基本方法 ---")
    val calculator = Calculator()
    println("1 + 2 = ${calculator.add(1, 2)}")
    println("5 - 3 = ${calculator.subtract(5, 3)}")
    
    // 4.2 默认参数和命名参数
    println("\n--- 4.2 默认参数和命名参数 ---")
    val greeting1 = calculator.greet("李四")
    println(greeting1)
    
    val greeting2 = calculator.greet("王五", "晚上好")
    println(greeting2)
    
    // 命名参数可以改变参数顺序
    val greeting3 = calculator.greet(greeting = "你好", name = "赵六")
    println(greeting3)
    
    // 4.3 单表达式函数
    println("\n--- 4.3 单表达式函数 ---")
    println("3 * 4 = ${calculator.multiply(3, 4)}")
    
    // 4.4 可变参数
    println("\n--- 4.4 可变参数 ---")
    println("求和: 1 + 2 + 3 = ${calculator.sum(1, 2, 3)}")
    println("求和: 1 到 5 = ${calculator.sum(1, 2, 3, 4, 5)}")
    
    // 使用展开运算符传递数组
    val numbers = intArrayOf(1, 2, 3, 4, 5, 6)
    println("数组求和: ${calculator.sum(*numbers)}")
    
    // 4.5 中缀表示法
    println("\n--- 4.5 中缀表示法 ---")
    // 使用中缀表示法调用方法
    println("使用中缀表示法: 3 plus 4 = ${3 plus 4}")
    
    // 4.6 局部函数
    println("\n--- 4.6 局部函数 ---")
    calculator.processNumbers(10, 5)
}

/**
 * 计算器类 - 用于演示方法的各种特性
 */
class Calculator {
    /**
     * 4.1 基本方法
     * 
     * 基本方法包含：
     * - 方法名
     * - 参数列表（可选）
     * - 返回类型（可选，如果能推断出来）
     * - 方法体
     * 
     * @param a 第一个数
     * @param b 第二个数
     * @return 两数之和
     */
    fun add(a: Int, b: Int): Int {
        return a + b
    }
    
    /**
     * 另一个基本方法示例
     * 
     * @param a 第一个数
     * @param b 第二个数
     * @return 两数之差
     */
    fun subtract(a: Int, b: Int): Int {
        return a - b
    }
    
    /**
     * 4.2 默认参数和命名参数
     * 
     * 默认参数：为参数提供默认值，调用时可以省略
     * 命名参数：使用参数名指定参数，可以改变参数顺序
     * 
     * @param name 人名
     * @param greeting 问候语，有默认值
     * @return 完整的问候语
     */
    fun greet(name: String, greeting: String = "你好"): String {
        return "$greeting, $name!"
    }
    
    /**
     * 4.3 单表达式函数
     * 
     * 当函数只有一个表达式时，可以省略花括号和 return 语句
     * 返回类型也可以省略，如果能被编译器推断
     * 
     * @param a 第一个数
     * @param b 第二个数
     * @return 两数之积
     */
    fun multiply(a: Int, b: Int) = a * b
    
    /**
     * 4.4 可变参数
     * 
     * 使用 vararg 关键字定义可变数量的参数
     * 在函数内部，它被视为一个数组
     * 
     * @param numbers 可变数量的整数
     * @return 所有数字的和
     */
    fun sum(vararg numbers: Int): Int {
        var result = 0
        for (number in numbers) {
            result += number
        }
        return result
    }
    
    /**
     * 4.6 局部函数
     * 
     * 在函数内部定义的函数，可以访问外部函数的参数和变量
     * 用于避免代码重复和提高封装性
     * 
     * @param a 第一个数
     * @param b 第二个数
     */
    fun processNumbers(a: Int, b: Int) {
        // 局部函数定义
        fun validateInput(num: Int, name: String) {
            if (num <= 0) {
                println("警告: $name 必须为正数，当前值: $num")
            }
        }
        
        // 调用局部函数
        validateInput(a, "a")
        validateInput(b, "b")
        
        // 使用参数进行计算
        println("a + b = ${a + b}")
        println("a - b = ${a - b}")
    }
}

/**
 * 4.5 中缀表示法
 * 
 * 中缀表示法允许以更自然的方式调用某些函数
 * 要使用中缀表示法，函数必须：
 * 1. 是成员函数或扩展函数
 * 2. 只有一个参数
 * 3. 使用 infix 关键字标记
 * 
 * 这里使用扩展函数实现
 */
infix fun Int.plus(other: Int): Int {
    println("使用中缀函数 plus")
    return this + other
}

/**
 * 第5部分：数据类
 * 
 * 数据类是专门用来存储数据的类，Kotlin 使用 data 关键字标记。
 * 数据类自动生成以下函数：
 * - equals()/hashCode() - 基于所有属性的相等性比较
 * - toString() - 返回格式为 "类名(属性1=值1, 属性2=值2, ...)" 的字符串
 * - componentN() - 用于解构声明
 * - copy() - 创建对象副本，可以修改部分属性
 * 
 * 数据类的要求：
 * 1. 主构造函数至少有一个参数
 * 2. 所有主构造函数参数必须标记为 val 或 var
 * 3. 数据类不能是抽象、开放、密封或内部的
 */
fun dataClasses() {
    println("\n=== 5. 数据类 ===")
    
    // 5.1 基本数据类
    println("\n--- 5.1 基本数据类 ---")
    val user1 = User("张三", 30, "zhangsan@example.com")
    println("用户信息: $user1")  // 自动生成的 toString()
    
    // 5.2 相等性比较
    println("\n--- 5.2 相等性比较 ---")
    val user2 = User("张三", 30, "zhangsan@example.com")
    val user3 = User("李四", 25, "lisi@example.com")
    
    println("user1 == user2: ${user1 == user2}")  // 内容相同，返回 true
    println("user1 == user3: ${user1 == user3}")  // 内容不同，返回 false
    
    // 5.3 复制对象
    println("\n--- 5.3 复制对象 ---")
    val updatedUser = user1.copy(age = 31)  // 只修改年龄
    println("原始用户: $user1")
    println("更新后用户: $updatedUser")
    
    // 5.4 解构声明
    println("\n--- 5.4 解构声明 ---")
    val (name, age, email) = user1  // 解构
    println("解构: 姓名=$name, 年龄=$age, 邮箱=$email")
    
    // 5.5 数据类与普通类的比较
    println("\n--- 5.5 数据类与普通类的比较 ---")
    val regularUser = RegularUser("王五", 35, "wangwu@example.com")
    val regularUser2 = RegularUser("王五", 35, "wangwu@example.com")
    
    println("普通类 toString(): $regularUser")  // 默认 toString() 不包含属性信息
    println("普通类相等性: ${regularUser == regularUser2}")  // 默认比较引用，不是内容
}

/**
 * 5.1 数据类定义
 * 
 * 使用 data 关键字定义数据类
 * 主构造函数参数必须使用 val 或 var 声明为属性
 * 
 * @param name 用户名
 * @param age 年龄
 * @param email 电子邮箱
 */
data class User(val name: String, var age: Int, val email: String) {
    // 数据类可以有额外的属性和方法
    var isActive: Boolean = true
    
    // 自定义方法
    fun sendEmail(message: String) {
        if (isActive) {
            println("向 $email 发送消息: $message")
        } else {
            println("用户未激活，无法发送邮件")
        }
    }
}

/**
 * 5.5 普通类 - 用于与数据类比较
 * 
 * 普通类没有自动生成的 equals(), hashCode(), toString() 等方法
 * 
 * @param name 用户名
 * @param age 年龄
 * @param email 电子邮箱
 */
class RegularUser(val name: String, var age: Int, val email: String) {
    // 普通类需要手动实现 equals(), hashCode(), toString() 等方法
    // 这里没有实现，使用默认行为
}

/**
 * 第6部分：枚举类和密封类
 * 
 * Kotlin 提供了两种特殊的类来表示受限的类层次结构：
 * 1. 枚举类（enum class）：表示一组固定的常量值
 * 2. 密封类（sealed class）：表示受限的类层次结构，所有子类必须在同一文件中声明
 * 
 * 这两种类都用于表示有限的集合，但有不同的用途和特性。
 */
fun enumsAndSealedClasses() {
    println("\n=== 6. 枚举类和密封类 ===")
    
    // 6.1 基本枚举类
    println("\n--- 6.1 基本枚举类 ---")
    val today = DayOfWeek.MONDAY
    println("今天是: $today")
    
    // 6.2 枚举类的属性和方法
    println("\n--- 6.2 枚举类的属性和方法 ---")
    println("${today.name} 是第 ${today.ordinal + 1} 天")
    println("${today.name} 的中文名是: ${today.chineseName}")
    
    // 枚举类的方法
    today.printInfo()
    
    // 6.3 使用 when 处理枚举
    println("\n--- 6.3 使用 when 处理枚举 ---")
    val message = when (today) {
        DayOfWeek.MONDAY -> "星期一，新的一周开始了"
        DayOfWeek.TUESDAY -> "星期二，继续努力"
        DayOfWeek.WEDNESDAY -> "星期三，已经过半了"
        DayOfWeek.THURSDAY -> "星期四，快到周末了"
        DayOfWeek.FRIDAY -> "星期五，准备迎接周末"
        DayOfWeek.SATURDAY, DayOfWeek.SUNDAY -> "周末，好好休息"
    }
    println(message)
    
    // 6.4 枚举类的静态方法
    println("\n--- 6.4 枚举类的静态方法和属性 ---")
    // 获取所有枚举值
    val allDays = DayOfWeek.values()
    println("一周的所有天: ${allDays.joinToString()}")
    
    // 通过名称获取枚举值
    val friday = DayOfWeek.valueOf("FRIDAY")
    println("通过名称获取: $friday")
    
    // 6.5 密封类
    println("\n--- 6.5 密封类 ---")
    val success = Result.Success("操作成功")
    val error = Result.Error("发生错误", 404)
    val loading = Result.Loading
    
    // 处理密封类实例
    processResult(success)
    processResult(error)
    processResult(loading)
}

/**
 * 6.1 枚举类
 * 
 * 枚举类用于表示一组固定的常量值
 * 每个枚举常量都是枚举类的实例
 * 
 * 枚举类可以：
 * - 有构造函数和属性
 * - 实现接口
 * - 定义方法
 * - 每个枚举常量可以有自己的匿名类实现
 */
enum class DayOfWeek(val chineseName: String) {
    // 枚举常量，每个都是 DayOfWeek 的实例
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");  // 注意最后一个常量后面的分号，如果后面有其他定义则必须加
    
    /**
     * 枚举类中的方法
     * 每个枚举常量都可以调用这个方法
     */
    fun printInfo() {
        println("$name ($chineseName) 是${if (this == SATURDAY || this == SUNDAY) "周末" else "工作日"}")
    }
    
    /**
     * 枚举类可以有伴生对象，用于定义静态方法和属性
     * 注意：枚举类已经内置了 values() 和 valueOf(String) 方法
     */
    companion object {
        fun isWeekend(day: DayOfWeek): Boolean {
            return day == SATURDAY || day == SUNDAY
        }
    }
}

/**
 * 6.5 密封类
 * 
 * 密封类用于表示受限的类层次结构
 * 所有直接子类必须在同一文件中声明
 * 
 * 密封类的特点：
 * - 抽象类，不能直接实例化
 * - 构造函数默认是 protected
 * - 子类可以是普通类、数据类、对象声明或另一个密封类
 * 
 * 密封类最常用于表示不同类型的结果或状态
 */
sealed class Result {
    /**
     * 成功结果 - 数据类
     * 
     * @param data 成功时的数据
     */
    data class Success(val data: String) : Result()
    
    /**
     * 错误结果 - 数据类
     * 
     * @param message 错误消息
     * @param code 错误代码
     */
    data class Error(val message: String, val code: Int) : Result()
    
    /**
     * 加载中状态 - 单例对象
     * 
     * 使用 object 声明为单例
     */
    object Loading : Result()
}

/**
 * 处理密封类的函数
 * 
 * 使用 when 表达式处理密封类的所有可能子类
 * 当 when 用于密封类时，如果覆盖了所有子类，就不需要 else 分支
 * 
 * @param result 要处理的结果
 */
fun processResult(result: Result) {
    when (result) {
        is Result.Success -> println("成功: ${result.data}")
        is Result.Error -> println("错误: ${result.message}, 代码: ${result.code}")
        is Result.Loading -> println("加载中...")
        // 不需要 else 分支，因为已经覆盖了所有可能的子类
    }
}

/**
 * 第7部分：对象实例化
 * 
 * Kotlin 提供了几种特殊的对象实例化方式：
 * 1. 对象表达式（object expression）：创建匿名类的实例
 * 2. 对象声明（object declaration）：创建单例
 * 3. 伴生对象（companion object）：类级别的方法和属性（类似于静态成员）
 * 
 * 这些特性使得 Kotlin 在处理单例模式、工厂模式和静态成员时更加灵活和简洁。
 */
fun objectInstantiation() {
    println("\n=== 7. 对象实例化 ===")
    
    // 7.1 对象表达式
    println("\n--- 7.1 对象表达式 ---")
    // 创建一个匿名类的实例，实现 Runnable 接口
    val runnable = object : Runnable {
        override fun run() {
            println("匿名对象正在运行")
        }
    }
    
    // 使用匿名对象
    runnable.run()
    
    // 带属性和方法的匿名对象
    val anonymousObject = object {
        var x: Int = 10
        var y: Int = 20
        
        fun sum() = x + y
    }
    
    println("匿名对象: x=${anonymousObject.x}, y=${anonymousObject.y}, sum=${anonymousObject.sum()}")
    
    // 7.2 对象声明
    println("\n--- 7.2 对象声明（单例） ---")
    // 使用单例对象
    println("应用名称: ${AppConfig.appName}")
    println("应用版本: ${AppConfig.appVersion}")
    AppConfig.logInfo("这是一条信息日志")
    
    // 7.3 伴生对象
    println("\n--- 7.3 伴生对象 ---")
    // 通过类名直接访问伴生对象的成员
    val user = User2.createUser("张三", "zhangsan@example.com")
    println("通过工厂方法创建的用户: $user")
    println("用户计数: ${User2.userCount}")
    
    // 7.4 嵌套对象
    println("\n--- 7.4 嵌套对象 ---")
    // 访问嵌套对象
    println("默认设置: ${Settings.Default.theme}, ${Settings.Default.fontSize}")
    
    // 修改设置
    Settings.Default.theme = "Dark"
    println("修改后的主题: ${Settings.Default.theme}")
}

/**
 * 7.2 对象声明 - 单例模式
 * 
 * 使用 object 关键字声明一个单例对象
 * 对象声明结合了类声明和单个实例的创建
 * 
 * 单例对象的特点：
 * - 在首次访问时延迟初始化
 * - 线程安全
 * - 不能有构造函数
 * - 可以有属性、方法、初始化块
 * - 可以继承类和实现接口
 */
object AppConfig {
    // 属性
    val appName: String = "Kotlin学习应用"
    val appVersion: String = "1.0.0"
    private val logTag: String = "AppConfig"
    
    // 初始化块
    init {
        println("AppConfig 单例被初始化")
    }
    
    // 方法
    fun logInfo(message: String) {
        println("[$logTag] INFO: $message")
    }
    
    fun logError(message: String) {
        println("[$logTag] ERROR: $message")
    }
}

/**
 * 7.3 伴生对象
 * 
 * 伴生对象是在类内部使用 companion object 声明的对象
 * 它类似于其他语言中的静态成员，但实际上是类的单例伴生对象
 * 
 * 伴生对象的特点：
 * - 每个类只能有一个伴生对象
 * - 可以通过类名直接访问伴生对象的成员
 * - 可以有名称，如果没有指定，默认名称是 Companion
 * - 可以实现接口
 */
class User2 private constructor(val name: String, val email: String) {
    
    /**
     * 伴生对象 - 用于存放工厂方法和"静态"成员
     */
    companion object Factory {
        // "静态"属性
        var userCount: Int = 0
            private set  // 私有 setter，外部不能修改
        
        // 工厂方法
        fun createUser(name: String, email: String): User2 {
            userCount++
            println("创建了第 $userCount 个用户")
            return User2(name, email)
        }
        
        // 另一个工厂方法，创建匿名用户
        fun createAnonymousUser(): User2 {
            return createUser("匿名用户", "anonymous@example.com")
        }
    }
    
    override fun toString(): String {
        return "User2(name='$name', email='$email')"
    }
}

/**
 * 7.4 嵌套对象
 * 
 * 对象声明可以嵌套在类或其他对象中
 * 这对于组织相关的单例很有用
 */
class Settings {
    /**
     * 嵌套的单例对象
     * 用于存储默认设置
     */
    object Default {
        var theme: String = "Light"
        var fontSize: Int = 14
        var showNotifications: Boolean = true
    }
    
    /**
     * 另一个嵌套对象
     * 用于存储系统设置
     */
    object System {
        val osName: String = "Kotlin OS"
        val maxMemory: Int = 1024
    }
}

/**
 * 第8部分：继承
 * 
 * 继承是面向对象编程的核心概念之一，允许一个类（子类）继承另一个类（父类）的属性和方法。
 * 
 * Kotlin 继承的特点：
 * 1. 所有类默认都是 final 的（不可继承），需要使用 open 关键字标记才能被继承
 * 2. 方法默认也是 final 的，需要使用 open 标记才能被重写
 * 3. 使用 : 符号表示继承关系
 * 4. 子类必须调用父类的构造函数
 * 5. 使用 override 关键字明确标记重写的方法和属性
 */
fun inheritance() {
    println("\n=== 8. 继承 ===")
    
    // 8.1 基本继承
    println("\n--- 8.1 基本继承 ---")
    val animal = Animal("动物", 3)
    animal.eat()
    animal.sleep()
    
    val dog = Dog("旺财", 2, "柴犬")
    dog.eat()  // 调用继承的方法
    dog.sleep()  // 调用重写的方法
    dog.bark()  // 调用子类特有的方法
    
    // 8.2 类型转换和检查
    println("\n--- 8.2 类型转换和检查 ---")
    // is 操作符（类型检查）
    if (dog is Animal) {
        println("狗是动物的一种")
    }
    
    if (dog is Dog) {
        println("这个对象确实是狗")
    }
    
    // as 操作符（类型转换）
    val animal2: Animal = dog  // 隐式向上转型
    val dog2 = animal2 as Dog  // 显式向下转型
    dog2.bark()
    
    // 8.3 多态
    println("\n--- 8.3 多态 ---")
    val animals = arrayOf(
        Animal("普通动物", 1),
        Dog("小黑", 3, "拉布拉多"),
        Cat("咪咪", 2)
    )
    
    // 多态：同一个方法调用在不同对象上有不同的行为
    for (a in animals) {
        print("${a.name}: ")
        a.makeSound()  // 调用的具体方法取决于对象的实际类型
    }
    
    // 8.4 抽象类
    println("\n--- 8.4 抽象类 ---")
    // 抽象类不能直接实例化
    // val shape = Shape()  // 错误
    
    val circle = Circle(5.0)
    println("圆的面积: ${circle.area()}")
    println("圆的周长: ${circle.perimeter()}")
    
    val rectangle = Rectangle(4.0, 6.0)
    println("矩形的面积: ${rectangle.area()}")
    println("矩形的周长: ${rectangle.perimeter()}")
}

/**
 * 8.1 基类
 * 
 * 使用 open 关键字标记类可以被继承
 * 默认情况下，Kotlin 中的类是 final 的（不可继承）
 * 
 * @param name 动物名称
 * @param age 年龄
 */
open class Animal(val name: String, var age: Int) {
    
    /**
     * 使用 open 关键字标记方法可以被重写
     * 默认情况下，方法是 final 的（不可重写）
     */
    open fun eat() {
        println("$name 正在吃东西")
    }
    
    /**
     * 另一个可以被重写的方法
     */
    open fun sleep() {
        println("$name 正在睡觉")
    }
    
    /**
     * 可以被重写的方法，用于多态演示
     */
    open fun makeSound() {
        println("动物发出声音")
    }
}

/**
 * 8.1 子类
 * 
 * 使用 : 符号表示继承
 * 子类必须调用父类的构造函数
 * 
 * @param name 狗的名称
 * @param age 年龄
 * @param breed 品种
 */
class Dog(name: String, age: Int, val breed: String) : Animal(name, age) {
    
    /**
     * 使用 override 关键字重写父类方法
     * 重写的方法默认是 open 的，可以被子类继续重写
     * 可以使用 final 关键字阻止进一步重写
     */
    override fun sleep() {
        println("$name (${breed}狗) 蜷缩着睡觉")
    }
    
    /**
     * 子类特有的方法
     */
    fun bark() {
        println("$name: 汪汪汪!")
    }
    
    /**
     * 重写多态方法
     */
    override fun makeSound() {
        println("汪汪汪!")
    }
}

/**
 * 另一个子类，用于多态演示
 * 
 * @param name 猫的名称
 * @param age 年龄
 */
class Cat(name: String, age: Int) : Animal(name, age) {
    
    /**
     * 重写多态方法
     */
    override fun makeSound() {
        println("喵喵喵~")
    }
    
    /**
     * 重写父类方法
     */
    override fun sleep() {
        println("$name 在阳光下睡觉")
    }
}

/**
 * 8.4 抽象类
 * 
 * 抽象类使用 abstract 关键字标记
 * 抽象类不能被实例化，只能被继承
 * 抽象类可以包含抽象方法和具体方法
 * 
 * 抽象类的用途：
 * - 定义子类必须实现的方法
 * - 提供部分实现，减少子类的重复代码
 * - 建立类的层次结构
 */
abstract class Shape {
    /**
     * 抽象属性 - 没有初始值，必须由子类提供
     */
    abstract val shapeName: String
    
    /**
     * 抽象方法 - 没有实现，必须由子类实现
     * 
     * @return 形状的面积
     */
    abstract fun area(): Double
    
    /**
     * 抽象方法 - 计算周长
     * 
     * @return 形状的周长
     */
    abstract fun perimeter(): Double
    
    /**
     * 具体方法 - 所有子类都继承这个实现
     */
    fun printInfo() {
        println("这是一个$shapeName，面积为${area()}，周长为${perimeter()}")
    }
}

/**
 * 圆形 - 继承抽象类
 * 
 * @param radius 半径
 */
class Circle(val radius: Double) : Shape() {
    // 实现抽象属性
    override val shapeName: String = "圆形"
    
    // 实现抽象方法
    override fun area(): Double {
        return Math.PI * radius * radius
    }
    
    override fun perimeter(): Double {
        return 2 * Math.PI * radius
    }
}

/**
 * 矩形 - 继承抽象类
 * 
 * @param width 宽度
 * @param height 高度
 */
class Rectangle(val width: Double, val height: Double) : Shape() {
    // 实现抽象属性
    override val shapeName: String = "矩形"
    
    // 实现抽象方法
    override fun area(): Double {
        return width * height
    }
    
    override fun perimeter(): Double {
        return 2 * (width + height)
    }
}

/**
 * 第9部分：抽象类和接口
 * 
 * 抽象类和接口都是用来定义类型的契约，但它们有不同的用途和特点：
 * 
 * 抽象类：
 * - 使用 abstract 关键字
 * - 可以有构造函数
 * - 可以有状态（属性）
 * - 可以有抽象和具体方法
 * - 一个类只能继承一个抽象类
 * 
 * 接口：
 * - 使用 interface 关键字
 * - 不能有构造函数
 * - 可以有抽象属性和方法
 * - 可以有默认实现（但不能有状态）
 * - 一个类可以实现多个接口
 */
fun abstraction() {
    println("\n=== 9. 抽象类和接口 ===")
    
    // 9.1 抽象类
    println("\n--- 9.1 抽象类 ---")
    val employee = Employee("张三", 30, 10000.0)
    employee.work()
    employee.takeBreak()
    println("${employee.name} 的年薪是: ${employee.calculateAnnualSalary()}")
    
    // 9.2 接口
    println("\n--- 9.2 接口 ---")
    val swimmer = SwimmingAthlete("李四", 25)
    swimmer.swim()  // 接口方法
    swimmer.compete()  // 抽象类方法
    
    // 9.3 多接口实现
    println("\n--- 9.3 多接口实现 ---")
    val triathlete = Triathlete("王五", 28)
    triathlete.swim()
    triathlete.run()
    triathlete.cycle()
    triathlete.compete()
    
    // 9.4 接口代理
    println("\n--- 9.4 接口代理 ---")
    val delegatingAthlete = DelegatingAthlete("赵六", 32)
    delegatingAthlete.swim()
    delegatingAthlete.run()
    delegatingAthlete.compete()
}

/**
 * 9.1 抽象类
 * 
 * 抽象类定义了一个类型的骨架，包含了一些实现和一些需要子类实现的抽象方法
 * 
 * @param name 姓名
 * @param age 年龄
 */
abstract class Person6(val name: String, val age: Int) {
    
    /**
     * 抽象方法 - 必须由子类实现
     */
    abstract fun work()
    
    /**
     * 具体方法 - 子类继承这个实现
     */
    fun takeBreak() {
        println("$name 正在休息")
    }
    
    /**
     * 具体方法，但可以被重写
     */
    open fun introduce() {
        println("我是 $name，今年 $age 岁")
    }
}

/**
 * Person6 的具体子类
 * 
 * @param name 姓名
 * @param age 年龄
 * @param monthlySalary 月薪
 */
class Employee(name: String, age: Int, val monthlySalary: Double) : Person6(name, age) {
    
    /**
     * 实现抽象方法
     */
    override fun work() {
        println("$name 正在工作")
    }
    
    /**
     * 重写具体方法
     */
    override fun introduce() {
        super.introduce()  // 调用父类方法
        println("我是一名员工，月薪 $monthlySalary 元")
    }
    
    /**
     * 子类特有的方法
     */
    fun calculateAnnualSalary(): Double {
        return monthlySalary * 12
    }
}

/**
 * 9.2 接口
 * 
 * 接口定义了一个类型可以做什么，而不关心它是什么
 * 接口可以有抽象属性和方法
 */
interface Swimmer {
    /**
     * 抽象方法 - 必须实现
     */
    fun swim()
    
    /**
     * 带默认实现的方法 - 可以重写，也可以直接使用
     */
    fun float() {
        println("漂浮在水面上")
    }
}

/**
 * 另一个接口
 */
interface Runner {
    fun run()
}

/**
 * 第三个接口
 */
interface Cyclist {
    fun cycle()
}

/**
 * 抽象类 - 运动员
 */
abstract class Athlete(name: String, age: Int) : Person6(name, age) {
    /**
     * 运动员特有的抽象方法
     */
    abstract fun compete()
    
    /**
     * 重写父类方法
     */
    override fun work() {
        println("$name 正在训练")
    }
}

/**
 * 9.2 同时继承抽象类和实现接口
 * 
 * 一个类可以继承一个抽象类，同时实现一个或多个接口
 */
class SwimmingAthlete(name: String, age: Int) : Athlete(name, age), Swimmer {
    /**
     * 实现接口方法
     */
    override fun swim() {
        println("$name 正在游泳")
    }
    
    /**
     * 实现抽象类方法
     */
    override fun compete() {
        println("$name 正在参加游泳比赛")
    }
}

/**
 * 9.3 多接口实现
 * 
 * 一个类可以实现多个接口
 */
class Triathlete(name: String, age: Int) : Athlete(name, age), Swimmer, Runner, Cyclist {
    override fun swim() {
        println("$name 正在游泳训练")
    }
    
    override fun run() {
        println("$name 正在跑步训练")
    }
    
    override fun cycle() {
        println("$name 正在骑车训练")
    }
    
    override fun compete() {
        println("$name 正在参加铁人三项比赛")
    }
}

/**
 * 9.4 接口代理
 * 
 * Kotlin 支持接口代理，可以将接口的实现委托给其他对象
 * 这是一种组合优于继承的实现方式
 */
class SwimmerImpl(val name: String) : Swimmer {
    override fun swim() {
        println("$name 使用自由泳技术游泳")
    }
}

class RunnerImpl(val name: String) : Runner {
    override fun run() {
        println("$name 使用长跑技术跑步")
    }
}

/**
 * 使用 by 关键字实现接口代理
 * 
 * 这种方式可以避免手动实现所有接口方法，减少代码重复
 */
class DelegatingAthlete(name: String, age: Int) : Athlete(name, age),
    Swimmer by SwimmerImpl(name),  // 委托给 SwimmerImpl
    Runner by RunnerImpl(name)     // 委托给 RunnerImpl
{
    override fun compete() {
        println("$name 正在参加比赛，使用代理实现的技术")
    }
}

/**
 * 第10部分：接口
 * 
 * 接口是定义类型行为的契约，不关心实现细节。
 * Kotlin 的接口比 Java 更强大，可以包含：
 * 1. 抽象方法
 * 2. 默认实现的方法
 * 3. 抽象属性
 * 
 * Kotlin 接口的特点：
 * - 使用 interface 关键字定义
 * - 一个类可以实现多个接口
 * - 接口可以继承其他接口
 * - 接口不能有构造函数
 * - 接口方法默认是 open 的
 */
fun interfaces() {
    println("\n=== 10. 接口 ===")
    
    // 10.1 基本接口实现
    println("\n--- 10.1 基本接口实现 ---")
    val vehicle = Car("红色轿车", 5)
    vehicle.start()
    vehicle.stop()
    vehicle.honk()
    
    // 10.2 接口继承
    println("\n--- 10.2 接口继承 ---")
    val electricCar = ElectricCar("特斯拉", 5)
    electricCar.start()  // Vehicle 接口方法
    electricCar.charge() // ElectricVehicle 接口方法
    
    // 10.3 接口默认方法
    println("\n--- 10.3 接口默认方法 ---")
    vehicle.displayInfo()  // 使用默认实现
    electricCar.displayInfo()  // 重写的默认实现
    
    // 10.4 接口属性
    println("\n--- 10.4 接口属性 ---")
    println("车辆类型: ${vehicle.type}")
    println("电动车类型: ${electricCar.type}")
    
    // 10.5 函数式接口
    println("\n--- 10.5 函数式接口 ---")
    // 使用对象表达式实现函数式接口
    val clickHandler = object : OnClickListener {
        override fun onClick() {
            println("按钮被点击了")
        }
    }
    
    // 调用函数式接口方法
    val button = Button("登录")
    button.setOnClickListener(clickHandler)
    button.click()
    
    // 使用 lambda 表达式实现函数式接口
    button.setOnClickListener { println("使用 lambda 表达式: 按钮被点击了") }
    button.click()
}

/**
 * 10.1 基本接口
 * 
 * 接口定义了一组相关的方法和属性，表示一种能力或行为
 */
interface Vehicle {
    /**
     * 抽象属性 - 必须由实现类提供
     */
    val type: String
    
    /**
     * 抽象方法 - 必须由实现类提供实现
     */
    fun start()
    
    /**
     * 抽象方法
     */
    fun stop()
    
    /**
     * 带默认实现的方法
     * 实现类可以使用默认实现，也可以提供自己的实现
     */
    fun displayInfo() {
        println("这是一个 $type")
    }
}

/**
 * 10.1 接口实现
 * 
 * 使用 : 符号表示实现接口
 */
class Car(val name: String, val seats: Int) : Vehicle {
    // 实现接口抽象属性
    override val type: String = "汽车"
    
    // 实现接口抽象方法
    override fun start() {
        println("$name 启动引擎")
    }
    
    override fun stop() {
        println("$name 停止引擎")
    }
    
    // 类自己的方法
    fun honk() {
        println("$name 按喇叭: 嘟嘟!")
    }
}

/**
 * 10.2 接口继承
 * 
 * 接口可以继承其他接口，形成接口层次结构
 */
interface ElectricVehicle : Vehicle {
    /**
     * 电动车特有的方法
     */
    fun charge()
    
    /**
     * 重写父接口的默认方法
     */
    override fun displayInfo() {
        println("这是一个电动$type")
    }
}

/**
 * 10.2 实现多个接口
 * 
 * 一个类可以实现多个接口
 */
class ElectricCar(val name: String, val seats: Int) : ElectricVehicle {
    // 实现接口属性
    override val type: String = "电动汽车"
    
    // 实现 Vehicle 接口方法
    override fun start() {
        println("$name 启动电机")
    }
    
    override fun stop() {
        println("$name 停止电机")
    }
    
    // 实现 ElectricVehicle 接口方法
    override fun charge() {
        println("$name 正在充电")
    }
}

/**
 * 10.5 函数式接口 (SAM - Single Abstract Method)
 * 
 * 只有一个抽象方法的接口称为函数式接口
 * 可以使用 fun 关键字标记，允许使用 lambda 表达式实现
 */
fun interface OnClickListener {
    /**
     * 点击事件处理方法
     */
    fun onClick()
}

/**
 * 使用函数式接口的类
 */
class Button(val text: String) {
    private var clickListener: OnClickListener? = null
    
    /**
     * 设置点击监听器
     */
    fun setOnClickListener(listener: OnClickListener) {
        this.clickListener = listener
    }
    
    /**
     * 模拟按钮点击
     */
    fun click() {
        println("按钮 '$text' 被点击")
        clickListener?.onClick()
    }
}

/**
 * 第11部分：多态
 * 
 * 多态是面向对象编程的核心概念之一，允许使用父类类型引用子类对象，
 * 并且在运行时根据对象的实际类型调用适当的方法。
 * 
 * Kotlin 中的多态表现形式：
 * 1. 继承多态：通过继承实现
 * 2. 接口多态：通过接口实现
 * 3. 参数多态：通过泛型实现
 * 
 * 多态的好处：
 * - 提高代码的灵活性和可扩展性
 * - 实现"依赖于抽象而不是具体实现"的设计原则
 * - 支持"开闭原则"：对扩展开放，对修改关闭
 */
fun polymorphism() {
    println("\n=== 11. 多态 ===")
    
    // 11.1 继承多态
    println("\n--- 11.1 继承多态 ---")
    // 使用父类引用指向子类对象
    val shape1: Shape2 = Circle2(5.0)
    val shape2: Shape2 = Rectangle2(4.0, 6.0)
    val shape3: Shape2 = Triangle(3.0, 4.0, 5.0)
    
    // 多态调用 - 根据实际对象类型调用不同的实现
    println("形状1: ${shape1.name}, 面积: ${shape1.calculateArea()}")
    println("形状2: ${shape2.name}, 面积: ${shape2.calculateArea()}")
    println("形状3: ${shape3.name}, 面积: ${shape3.calculateArea()}")
    
    // 11.2 接口多态
    println("\n--- 11.2 接口多态 ---")
    // 使用接口类型引用实现类对象
    val drawable1: Drawable = Circle2(5.0)
    val drawable2: Drawable = Rectangle2(4.0, 6.0)
    val drawable3: Drawable = Text("Hello")
    
    // 多态调用 - 根据实际对象类型调用不同的实现
    drawable1.draw()
    drawable2.draw()
    drawable3.draw()
    
    // 11.3 智能类型转换
    println("\n--- 11.3 智能类型转换 ---")
    processShape(shape1)
    processShape(shape2)
    processShape(shape3)
    
    // 11.4 多态集合
    println("\n--- 11.4 多态集合 ---")
    // 创建不同类型对象的集合
    val drawables: List<Drawable> = listOf(
        Circle2(3.0),
        Rectangle2(2.0, 4.0),
        Text("Kotlin"),
        Circle2(2.5)
    )
    
    // 遍历并多态调用方法
    println("绘制所有对象:")
    for (drawable in drawables) {
        drawable.draw()
    }
    
    // 11.5 泛型多态
    println("\n--- 11.5 泛型多态 ---")
    // 创建不同类型的 Box
    val intBox = Box(42)
    val stringBox = Box("Hello")
    val circleBox = Box(Circle2(1.0))
    
    // 多态调用
    println("整数盒子: ${intBox.getValue()}")
    println("字符串盒子: ${stringBox.getValue()}")
    println("圆形盒子: ${circleBox.getValue().name}")
}

/**
 * 11.1 多态基类
 * 
 * 用于演示继承多态的基类
 */
abstract class Shape2 {
    abstract val name: String
    
    /**
     * 抽象方法 - 子类必须提供实现
     */
    abstract fun calculateArea(): Double
    
    /**
     * 具体方法 - 所有子类共享
     */
    fun printInfo() {
        println("这是一个$name，面积为${calculateArea()}")
    }
}

/**
 * 11.2 可绘制接口
 * 
 * 用于演示接口多态
 */
interface Drawable {
    /**
     * 绘制方法
     */
    fun draw()
}

/**
 * 圆形 - 继承 Shape2 并实现 Drawable 接口
 */
class Circle2(val radius: Double) : Shape2(), Drawable {
    override val name: String = "圆形"
    
    override fun calculateArea(): Double {
        return Math.PI * radius * radius
    }
    
    override fun draw() {
        println("绘制圆形，半径: $radius")
    }
}

/**
 * 矩形 - 继承 Shape2 并实现 Drawable 接口
 */
class Rectangle2(val width: Double, val height: Double) : Shape2(), Drawable {
    override val name: String = "矩形"
    
    override fun calculateArea(): Double {
        return width * height
    }
    
    override fun draw() {
        println("绘制矩形，宽: $width, 高: $height")
    }
}

/**
 * 三角形 - 继承 Shape2
 */
class Triangle(val a: Double, val b: Double, val c: Double) : Shape2() {
    override val name: String = "三角形"
    
    override fun calculateArea(): Double {
        // 使用海伦公式计算三角形面积
        val s = (a + b + c) / 2
        return Math.sqrt(s * (s - a) * (s - b) * (s - c))
    }
}

/**
 * 文本 - 只实现 Drawable 接口
 */
class Text(val content: String) : Drawable {
    override fun draw() {
        println("绘制文本: \"$content\"")
    }
}

/**
 * 11.3 智能类型转换
 * 
 * 处理形状的函数，演示智能类型转换
 */
fun processShape(shape: Shape2) {
    println("处理 ${shape.name}:")
    
    // 基本信息
    shape.printInfo()
    
    // 使用 is 检查类型并智能转换
    when (shape) {
        is Circle2 -> {
            // 智能类型转换 - 可以直接访问 Circle2 的属性
            println("这是一个圆，半径: ${shape.radius}")
            shape.draw()  // 调用 Circle2 特有的方法
        }
        is Rectangle2 -> {
            // 智能类型转换 - 可以直接访问 Rectangle2 的属性
            println("这是一个矩形，宽: ${shape.width}, 高: ${shape.height}")
            shape.draw()  // 调用 Rectangle2 特有的方法
        }
        is Triangle -> {
            // 智能类型转换 - 可以直接访问 Triangle 的属性
            println("这是一个三角形，边长: ${shape.a}, ${shape.b}, ${shape.c}")
        }
    }
}

/**
 * 11.5 泛型类
 * 
 * 用于演示参数多态（泛型）
 */
class Box<T>(private val value: T) {
    /**
     * 泛型方法
     */
    fun getValue(): T {
        return value
    }
    
    /**
     * 打印值的类型和字符串表示
     */
    fun printTypeAndValue() {
        println("类型: ${value?.javaClass?.simpleName}, 值: $value")
    }
}

/**
 * 第12部分：可见性修饰符
 * 
 * Kotlin 提供了四种可见性修饰符，用于控制类、属性、方法等的访问范围：
 * 
 * 1. public（默认）：可以在任何地方访问
 * 2. internal：同一模块内可访问
 * 3. protected：只在类及其子类中可访问
 * 4. private：只在声明它的类或文件中可访问
 * 
 * 可见性修饰符可以应用于：
 * - 类和接口
 * - 构造函数
 * - 属性和字段
 * - 方法和函数
 */
fun visibilityModifiers() {
    println("\n=== 12. 可见性修饰符 ===")
    
    // 12.1 public 修饰符
    println("\n--- 12.1 public 修饰符 ---")
    val publicExample = PublicExample()
    publicExample.publicMethod()  // 可以访问 public 方法
    println("Public 属性: ${publicExample.publicProperty}")
    
    // 12.2 private 修饰符
    println("\n--- 12.2 private 修饰符 ---")
    val privateExample = PrivateExample()
    // privateExample.privateMethod()  // 错误：无法访问 private 方法
    // println(privateExample.privateProperty)  // 错误：无法访问 private 属性
    privateExample.accessPrivateMembers()  // 通过公共方法间接访问私有成员
    
    // 12.3 protected 修饰符
    println("\n--- 12.3 protected 修饰符 ---")
    val child = Child()
    // child.protectedMethod()  // 错误：无法从外部访问 protected 方法
    child.accessProtectedMembers()  // 子类可以访问父类的 protected 成员
    
    // 12.4 internal 修饰符
    println("\n--- 12.4 internal 修饰符 ---")
    val internalExample = InternalExample()
    internalExample.internalMethod()  // 同一模块内可以访问 internal 方法
    println("Internal 属性: ${internalExample.internalProperty}")
    
    // 12.5 构造函数可见性
    println("\n--- 12.5 构造函数可见性 ---")
    val publicConstructor = ClassWithPublicConstructor("公共构造函数")
    // val privateConstructor = ClassWithPrivateConstructor("私有构造函数")  // 错误：无法访问私有构造函数
    
    // 使用工厂方法创建对象
    val instance = ClassWithPrivateConstructor.create("通过工厂方法创建")
    instance.showInfo()
}

/**
 * 12.1 public 修饰符
 * 
 * public 是默认的可见性修饰符，可以在任何地方访问
 */
class PublicExample {
    // 公共属性
    var publicProperty: String = "这是一个公共属性"
    
    // 公共方法
    fun publicMethod() {
        println("这是一个公共方法")
    }
}

/**
 * 12.2 private 修饰符
 * 
 * private 成员只在声明它的类中可见
 */
class PrivateExample {
    // 私有属性
    private var privateProperty: String = "这是一个私有属性"
    
    // 私有方法
    private fun privateMethod() {
        println("这是一个私有方法")
    }
    
    // 公共方法，用于访问私有成员
    fun accessPrivateMembers() {
        println("通过公共方法访问: $privateProperty")
        privateMethod()
    }
}

/**
 * 12.3 protected 修饰符
 * 
 * protected 成员只在类及其子类中可见
 */
open class Parent {
    // protected 属性
    protected val protectedProperty: String = "这是一个受保护的属性"
    
    // protected 方法
    protected fun protectedMethod() {
        println("这是一个受保护的方法")
    }
}

/**
 * 继承 Parent 类的子类
 */
class Child : Parent() {
    // 子类可以访问父类的 protected 成员
    fun accessProtectedMembers() {
        println("子类访问父类的受保护成员: $protectedProperty")
        protectedMethod()
    }
}

/**
 * 12.4 internal 修饰符
 * 
 * internal 成员在同一模块内可见
 * 模块是指一起编译的一组 Kotlin 文件
 */
class InternalExample {
    // internal 属性
    internal val internalProperty: String = "这是一个内部属性"
    
    // internal 方法
    internal fun internalMethod() {
        println("这是一个内部方法")
    }
}

/**
 * 12.5 构造函数可见性
 * 
 * 构造函数也可以有可见性修饰符
 */
class ClassWithPublicConstructor(val name: String) {
    fun showInfo() {
        println("使用公共构造函数创建: $name")
    }
}

/**
 * 带私有构造函数的类
 * 
 * 私有构造函数通常与工厂方法或伴生对象一起使用
 */
class ClassWithPrivateConstructor private constructor(val name: String) {
    fun showInfo() {
        println("使用私有构造函数创建: $name")
    }
    
    companion object {
        // 工厂方法，用于创建实例
        fun create(name: String): ClassWithPrivateConstructor {
            return ClassWithPrivateConstructor(name)
        }
    }
}

/**
 * 文件级别的私有函数
 * 
 * 只在当前文件中可见
 */
private fun filePrivateFunction() {
    println("这是一个文件级私有函数")
}

/**
 * 文件级别的内部函数
 * 
 * 在同一模块内可见
 */
internal fun moduleInternalFunction() {
    println("这是一个模块内部函数")
}

/**
 * 第13部分：对象表达式
 * 
 * Kotlin 中的对象表达式用于创建匿名类的实例。
 * 它们类似于 Java 中的匿名内部类，但功能更强大。
 * 
 * 对象表达式的用途：
 * 1. 创建接口或抽象类的匿名实现
 * 2. 扩展现有类的功能
 * 3. 实现一次性使用的类
 * 4. 创建带有额外属性和方法的对象
 */
fun objectExpressions() {
    println("\n=== 13. 对象表达式 ===")
    
    // 13.1 基本对象表达式
    println("\n--- 13.1 基本对象表达式 ---")
    // 创建一个实现 Runnable 接口的匿名对象
    val runnable = object : Runnable {
        override fun run() {
            println("匿名对象正在运行")
        }
    }
    
    // 使用匿名对象
    runnable.run()
    
    // 带属性和方法的匿名对象
    val anonymousObject = object {
        var x: Int = 10
        var y: Int = 20
        
        fun sum() = x + y
    }
    
    println("匿名对象: x=${anonymousObject.x}, y=${anonymousObject.y}, sum=${anonymousObject.sum()}")
    
    // 13.2 带属性和方法的匿名对象
    println("\n--- 13.2 带属性和方法的匿名对象 ---")
    val person = object {
        val name = "匿名人物"
        var age = 30
        
        fun introduce() {
            println("我是 $name，今年 $age 岁")
        }
    }
    
    // 使用匿名对象的属性和方法
    println("姓名: ${person.name}, 年龄: ${person.age}")
    person.introduce()
    
    // 13.3 继承类的匿名对象
    println("\n--- 13.3 继承类的匿名对象 ---")
    val specialPerson = object : Person1() {
        // 添加额外的属性
        val specialty = "编程"
        
        // 重写方法
        override fun introduce() {
            println("我是特殊的人，我擅长$specialty")
        }
        
        // 添加额外的方法
        fun showSpecialty() {
            println("我的特长是: $specialty")
        }
    }
    
    specialPerson.name = "匿名程序员"
    specialPerson.introduce()
    specialPerson.showSpecialty()
    
    // 13.4 在函数中返回匿名对象
    println("\n--- 13.4 在函数中返回匿名对象 ---")
    val comparator = getComparator()
    val result = comparator.compare(5, 10)
    println("比较结果: $result")
    
    // 13.5 对象表达式捕获变量
    println("\n--- 13.5 对象表达式捕获变量 ---")
    createCounter().count()
    
    // 13.6 事件监听器
    println("\n--- 13.6 事件监听器 ---")
    val button = Button2("提交")
    
    // 使用对象表达式添加点击监听器
    button.setOnClickListener(object : ClickListener {
        override fun onClick() {
            println("按钮被点击了")
        }
        
        override fun onLongClick() {
            println("按钮被长按了")
        }
    })
    
    // 触发事件
    button.performClick()
    button.performLongClick()
}

/**
 * 13.4 返回匿名对象的函数
 * 
 * 当函数返回匿名对象时，其类型会被推断为匿名对象实现的接口或继承的类
 */
fun getComparator(): Comparator<Int> {
    return object : Comparator<Int> {
        override fun compare(a: Int, b: Int): Int {
            return a - b
        }
    }
}

/**
 * 13.5 创建一个计数器
 * 
 * 匿名对象可以捕获外部函数的局部变量
 */
fun createCounter(): Counter {
    var count = 0  // 局部变量
    
    // 返回一个匿名对象，它可以访问并修改局部变量
    return object : Counter {
        override fun count(): Int {
            count++
            println("当前计数: $count")
            return count
        }
    }
}

/**
 * 计数器接口
 */
interface Counter {
    fun count(): Int
}

/**
 * 13.6 点击监听器接口
 */
interface ClickListener {
    fun onClick()
    fun onLongClick()
}

/**
 * 按钮类，用于演示事件监听
 */
class Button2(val text: String) {
    private var listener: ClickListener? = null
    
    /**
     * 设置点击监听器
     */
    fun setOnClickListener(listener: ClickListener) {
        this.listener = listener
    }
    
    /**
     * 模拟点击
     */
    fun performClick() {
        println("按钮 '$text' 被点击")
        listener?.onClick()
    }
    
    /**
     * 模拟长按
     */
    fun performLongClick() {
        println("按钮 '$text' 被长按")
        listener?.onLongClick()
    }
}

/**
 * 第14部分：嵌套类和内部类
 * 
 * Kotlin 支持在类中嵌套另一个类，有两种类型：
 * 1. 嵌套类（Nested Class）：使用 class 关键字定义，不持有外部类的引用
 * 2. 内部类（Inner Class）：使用 inner class 关键字定义，持有外部类的引用
 * 
 * 嵌套类和内部类的区别：
 * - 嵌套类不能访问外部类的成员
 * - 内部类可以访问外部类的成员
 * - 内部类持有对外部类实例的引用
 */
fun nestedAndInnerClasses() {
    println("\n=== 14. 嵌套类和内部类 ===")
    
    // 14.1 嵌套类
    println("\n--- 14.1 嵌套类 ---")
    // 创建嵌套类的实例，不需要外部类实例
    val nested = Outer.Nested()
    nested.nestedFunction()
    
    // 静态方式访问嵌套类的伴生对象成员
    println("嵌套类常量: ${Outer.Nested.NESTED_CONSTANT}")
    
    // 14.2 内部类
    println("\n--- 14.2 内部类 ---")
    // 创建内部类的实例，需要外部类实例
    val outer = Outer("外部类实例")
    val inner = outer.Inner("内部类实例")
    
    inner.innerFunction()
    inner.accessOuterMembers()
    
    // 14.3 嵌套接口和枚举
    println("\n--- 14.3 嵌套接口和枚举 ---")
    // 使用嵌套接口
    val implementer = InterfaceImplementer()
    implementer.execute()
    
    // 使用嵌套枚举
    println("状态: ${TaskStatus.RUNNING}")
    
    // 14.4 实际应用示例
    println("\n--- 14.4 实际应用示例 ---")
    val viewGroup = ViewGroup("主容器")
    val childView = viewGroup.createChildView("子视图")
    
    childView.render()
    childView.onClick()
}

/**
 * 14.1 & 14.2 外部类
 * 
 * 包含嵌套类和内部类的外部类
 */
class Outer(val name: String) {
    // 外部类的属性
    private val outerProperty = "外部属性"
    
    // 外部类的方法
    fun outerFunction() {
        println("外部类方法被调用")
    }
    
    /**
     * 14.1 嵌套类
     * 
     * 嵌套类相当于 Java 中的静态内部类
     * 不持有外部类的引用，不能访问外部类的成员
     */
    class Nested {
        // 嵌套类的属性
        val nestedProperty = "嵌套类属性"
        
        // 嵌套类的方法
        fun nestedFunction() {
            println("嵌套类方法被调用")
            // 不能访问外部类的成员
            // println(outerProperty)  // 错误
            // outerFunction()  // 错误
        }
        
        // 嵌套类可以有自己的伴生对象
        companion object {
            const val NESTED_CONSTANT = "嵌套类常量"
        }
    }
    
    /**
     * 14.2 内部类
     * 
     * 使用 inner 关键字定义内部类
     * 持有外部类的引用，可以访问外部类的成员
     */
    inner class Inner(val innerName: String) {
        // 内部类的属性
        val innerProperty = "内部类属性"
        
        // 内部类的方法
        fun innerFunction() {
            println("内部类方法被调用，名称: $innerName")
        }
        
        /**
         * 访问外部类成员的方法
         * 
         * 内部类可以访问外部类的所有成员，包括私有成员
         */
        fun accessOuterMembers() {
            println("内部类访问外部类名称: ${this@Outer.name}")
            println("内部类访问外部类属性: $outerProperty")
            outerFunction()
        }
    }
}

/**
 * 14.3 包含嵌套接口的类
 */
class Container {
    /**
     * 嵌套接口
     * 
     * 接口可以嵌套在类中，通常用于定义回调或监听器
     */
    interface Executable {
        fun execute()
    }
}

/**
 * 实现嵌套接口的类
 */
class InterfaceImplementer : Container.Executable {
    override fun execute() {
        println("执行嵌套接口方法")
    }
}

/**
 * 14.3 包含嵌套枚举的类
 */
class Task {
    /**
     * 嵌套枚举
     * 
     * 枚举可以嵌套在类中，通常用于表示与类相关的常量集合
     */
    enum class Status {
        PENDING,
        RUNNING,
        COMPLETED,
        FAILED
    }
}

// 使用类型别名简化嵌套类型的引用
typealias TaskStatus = Task.Status

/**
 * 14.4 实际应用示例 - 视图组
 * 
 * 演示嵌套类和内部类在实际应用中的使用
 */
class ViewGroup(val name: String) {
    // 视图组的属性
    private val children = mutableListOf<View>()
    
    /**
     * 创建子视图的方法
     * 
     * @param name 视图名称
     * @return 新创建的子视图
     */
    fun createChildView(name: String): ChildView {
        val childView = ChildView(name)
        children.add(childView)
        return childView
    }
    
    /**
     * 抽象视图类
     * 
     * 嵌套抽象类，定义所有视图的共同行为
     */
    abstract inner class View {
        abstract val viewName: String
        
        /**
         * 渲染方法
         */
        abstract fun render()
        
        /**
         * 点击事件处理
         */
        open fun onClick() {
            println("视图 $viewName 被点击，父容器: ${this@ViewGroup.name}")
        }
    }
    
    /**
     * 子视图类
     * 
     * 继承自嵌套抽象类的内部类
     */
    inner class ChildView(override val viewName: String) : View() {
        override fun render() {
            println("渲染子视图 $viewName 在容器 ${this@ViewGroup.name} 中")
        }
        
        /**
         * 重写点击事件处理
         */
        override fun onClick() {
            super.onClick()
            println("子视图特定的点击处理")
        }
    }
}

/**
 * 第15部分：扩展函数
 * 
 * Kotlin 的扩展函数允许我们在不修改类的情况下向类添加新的功能。
 * 扩展函数和扩展属性是 Kotlin 最强大的特性之一。
 * 
 * 扩展的类型：
 * 1. 扩展函数：向类添加新的方法
 * 2. 扩展属性：向类添加新的属性（只能是计算属性，不能有字段）
 * 
 * 扩展的特点：
 * - 不能访问被扩展类的私有成员
 * - 扩展函数不能被重写（不支持多态）
 * - 扩展函数是静态解析的，取决于声明的类型而不是实际类型
 * - 可以为可空类型定义扩展
 */
fun extensionFunctions() {
    println("\n=== 15. 扩展函数 ===")
    
    // 15.1 基本扩展函数
    println("\n--- 15.1 基本扩展函数 ---")
    val str = "Hello, Kotlin!"
    println("字符串长度: ${str.length}")  // 内置属性
    println("字符串单词数: ${str.countWords()}")  // 扩展函数
    
    // 15.2 扩展属性
    println("\n--- 15.2 扩展属性 ---")
    println("字符串的最后一个字符: ${str.lastChar}")  // 扩展属性
    
    // 15.3 可空类型的扩展
    println("\n--- 15.3 可空类型的扩展 ---")
    val nullableString: String? = null
    println("可空字符串长度: ${nullableString.safeLength()}")
    
    val nonNullString: String? = "Non-null string"
    println("非空字符串长度: ${nonNullString.safeLength()}")
    
    // 15.4 接收者类型与分发接收者
    println("\n--- 15.4 接收者类型与分发接收者 ---")
    val baseObj: Base = Derived()
    baseObj.printType()  // 输出 "Base"，因为扩展函数是静态解析的
    
    // 15.5 扩展函数作为成员
    println("\n--- 15.5 扩展函数作为成员 ---")
    val formatter = StringFormatter()
    println("格式化字符串: ${formatter.format("kotlin")}")
    
    // 15.6 实用扩展函数示例
    println("\n--- 15.6 实用扩展函数示例 ---")
    val numbers = listOf(1, 2, 3, 4, 5)
    println("列表求和: ${numbers.sum()}")  // 标准库扩展函数
    println("列表平均值: ${numbers.average()}")  // 标准库扩展函数
    
    // 自定义扩展函数
    val product = numbers.product()
    println("列表元素乘积: $product")
    
    // 链式调用扩展函数
    val result = "  hello, world!  "
        .trim()  // 标准库扩展函数
        .capitalize()  // 标准库扩展函数
        .removeVowels()  // 自定义扩展函数
    
    println("处理后的字符串: $result")
}

/**
 * 15.1 字符串的扩展函数
 * 
 * 计算字符串中的单词数
 * 
 * @return 字符串中的单词数
 */
fun String.countWords(): Int {
    return this.split(Regex("\\s+")).filter { it.isNotEmpty() }.size
}

/**
 * 15.2 字符串的扩展属性
 * 
 * 获取字符串的最后一个字符
 */
val String.lastChar: Char
    get() = this[this.length - 1]

/**
 * 15.3 可空类型的扩展函数
 * 
 * 安全获取字符串长度，如果为 null 则返回 0
 * 
 * @return 字符串长度或 0（如果为 null）
 */
fun String?.safeLength(): Int {
    // 使用安全调用和 Elvis 操作符
    return this?.length ?: 0
}

/**
 * 15.4 基类
 */
open class Base {
    open fun printMessage() {
        println("Base 类的方法")
    }
}

/**
 * 派生类
 */
class Derived : Base() {
    override fun printMessage() {
        println("Derived 类的方法")
    }
}

/**
 * 为 Base 类定义扩展函数
 * 
 * 扩展函数不支持多态，调用哪个扩展函数取决于声明的类型，而不是实际类型
 */
fun Base.printType() {
    println("Base")
}

/**
 * 为 Derived 类定义扩展函数
 */
fun Derived.printType() {
    println("Derived")
}

/**
 * 15.5 包含扩展函数的类
 * 
 * 扩展函数可以在类内部定义，作为成员函数
 */
class StringFormatter {
    /**
     * 在类内部定义的扩展函数
     * 
     * 这个扩展函数可以访问 StringFormatter 的成员
     */
    fun String.format(): String {
        return "[$this]"
    }
    
    /**
     * 使用类内部定义的扩展函数
     */
    fun format(str: String): String {
        return str.format()  // 调用扩展函数
    }
}

/**
 * 15.6 为集合定义扩展函数
 * 
 * 计算集合中所有元素的乘积
 * 
 * @return 所有元素的乘积
 */
fun List<Int>.product(): Int {
    var result = 1
    for (element in this) {
        result *= element
    }
    return result
}

/**
 * 移除字符串中的元音字母
 * 
 * @return 移除元音字母后的字符串
 */
fun String.removeVowels(): String {
    return this.replace(Regex("[aeiouAEIOU]"), "")
}

/**
 * 首字母大写
 * 
 * 注意：Kotlin 1.5 以上版本已经在标准库中提供了 capitalize() 方法
 * 这里为了演示扩展函数而实现
 */
fun String.capitalize(): String {
    if (this.isEmpty()) return this
    return this[0].uppercase() + this.substring(1)
}

/**
 * 第16部分：委托
 * 
 * Kotlin 支持两种类型的委托：
 * 1. 类委托：一个类将其一个或多个接口的实现委托给另一个对象
 * 2. 属性委托：一个属性将其访问器（getter/setter）委托给另一个对象
 * 
 * 委托模式是实现继承的一种替代方案，通过组合而不是继承来复用代码。
 * Kotlin 使用 by 关键字实现委托。
 */
fun delegation() {
    println("\n=== 16. 委托 ===")
    
    // 16.1 类委托
    println("\n--- 16.1 类委托 ---")
    val baseImpl = BaseImpl(10)
    val derived = DerivedByDelegate(baseImpl)
    
    derived.print()  // 委托给 baseImpl.print()
    println("值: ${derived.getValue()}")  // 委托给 baseImpl.getValue()
    
    // 16.2 属性委托 - 懒加载
    println("\n--- 16.2 属性委托 - 懒加载 ---")
    val lazyExample = LazyExample()
    println("懒加载属性初始化前...")
    println("访问懒加载属性: ${lazyExample.lazyValue}")
    println("再次访问懒加载属性: ${lazyExample.lazyValue}")
    
    // 16.3 属性委托 - Observable
    println("\n--- 16.3 属性委托 - Observable ---")
    val observableExample = ObservableExample()
    observableExample.observableName = "初始值"
    observableExample.observableName = "新值"
    
    // 16.4 属性委托 - Map
    println("\n--- 16.4 属性委托 - Map ---")
    val mapExample = MapExample(
        mapOf(
            "name" to "张三",
            "age" to 30
        )
    )
    
    println("从 Map 读取: 姓名=${mapExample.name}, 年龄=${mapExample.age}")
    
    // 16.5 自定义委托
    println("\n--- 16.5 自定义委托 ---")
    val customDelegateExample = CustomDelegateExample()
    customDelegateExample.delegatedString = "Hello"
    println("自定义委托值: ${customDelegateExample.delegatedString}")
    customDelegateExample.delegatedString = "World"
    println("修改后的值: ${customDelegateExample.delegatedString}")
    
    // 16.6 提供委托
    println("\n--- 16.6 提供委托 ---")
    val provider = DelegateProvider()
    val consumer = DelegateConsumer(provider)
    
    println("使用提供委托: ${consumer.providerValue}")
}

/**
 * 16.1 类委托 - 基础接口
 */
interface Base2 {
    fun print()
    fun getValue(): Int
}

/**
 * 基础接口的实现
 */
class BaseImpl(private val value: Int) : Base2 {
    override fun print() {
        println("BaseImpl: print()")
    }
    
    override fun getValue(): Int {
        return value
    }
}

/**
 * 使用委托的派生类
 * 
 * 使用 by 关键字将接口实现委托给另一个对象
 */
class DerivedByDelegate(private val base: Base2) : Base2 by base {
    // 可以重写委托对象的方法
    override fun print() {
        println("DerivedByDelegate: 首先执行自己的逻辑")
        base.print()  // 手动调用委托对象的方法
    }
    
    // 没有重写的方法会自动委托给 base 对象
    // getValue() 方法会自动委托给 base.getValue()
}

/**
 * 16.2 属性委托 - 懒加载
 * 
 * 使用 lazy 委托实现属性的懒加载（第一次访问时才初始化）
 */
class LazyExample {
    // 使用 lazy 委托，只有在首次访问时才会执行 lambda 并缓存结果
    val lazyValue: String by lazy {
        println("计算 lazyValue...")
        // 模拟耗时操作
        Thread.sleep(100)
        "Hello, Lazy!"
    }
}

/**
 * 16.3 属性委托 - Observable
 * 
 * 使用 Delegates.observable 监听属性变化
 */
class ObservableExample {
    // 使用 observable 委托，在属性变化时执行回调
    var observableName: String by Delegates.observable("初始值") { property, oldValue, newValue ->
        println("属性 ${property.name} 从 '$oldValue' 变为 '$newValue'")
    }
}

/**
 * 16.4 属性委托 - Map
 * 
 * 将属性值存储在 Map 中
 */
class MapExample(private val map: Map<String, Any?>) {
    // 使用 Map 存储属性值
    val name: String by map
    val age: Int by map
}

/**
 * 16.5 自定义委托 - 委托类
 * 
 * 实现 ReadWriteProperty 接口创建自定义委托
 */
class StringDelegate : ReadWriteProperty<Any?, String> {
    private var value: String = ""
    
    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("获取属性 ${property.name} 的值")
        return value
    }
    
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("设置属性 ${property.name} 的值为 $value")
        this.value = value
    }
}

/**
 * 使用自定义委托的类
 */
class CustomDelegateExample {
    // 使用自定义委托
    var delegatedString: String by StringDelegate()
}

/**
 * 16.6 提供委托 - 委托提供者
 * 
 * 使用 provideDelegate 操作符自定义创建委托的逻辑
 */
class DelegateProvider {
    // 提供委托的操作符方法
    operator fun provideDelegate(thisRef: Any?, property: KProperty<*>): ReadOnlyProperty<Any?, String> {
        println("为属性 ${property.name} 创建委托")
        
        // 根据属性名选择不同的委托实现
        return when (property.name) {
            "providerValue" -> SpecialReadOnlyProperty("特殊值")
            else -> SpecialReadOnlyProperty("默认值")
        }
    }
}

/**
 * 只读属性委托实现
 */
class SpecialReadOnlyProperty(private val value: String) : ReadOnlyProperty<Any?, String> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "[$value]"
    }
}

/**
 * 使用委托提供者的类
 */
class DelegateConsumer(provider: DelegateProvider) {
    // 使用委托提供者
    val providerValue: String by provider
}