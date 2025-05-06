// 智能家居设备示例 - Kotlin继承与多态的应用

/**
 * SmartDevice - 智能设备基类
 * 这是一个开放类(open)，允许其他类继承它
 * @param name 设备名称，使用val声明为只读属性
 * @param category 设备类别，使用val声明为只读属性
 */
open class SmartDevice(val name: String, val category: String) {
  // 设备状态，使用var声明为可变属性，初始值为"online"
  var deviceStatus = "online"

  // 设备类型，使用open关键字允许子类覆盖，默认值为"unknown"
  open val deviceType = "unknown"

  /**
   * 打开设备的方法
   * 使用open关键字允许子类覆盖此方法
   */
  open fun turnOn() {
    // 将设备状态设置为"on"
    deviceStatus = "on"
  }

  /**
   * 关闭设备的方法
   * 使用open关键字允许子类覆盖此方法
   */
  open fun turnOff() {
    // 将设备状态设置为"off"
    deviceStatus = "off"
  }
}

/**
 * SmartTvDevice - 智能电视设备类
 * 继承自SmartDevice基类
 * 
 * 注意：构造函数中的参数(deviceName, deviceCategory)没有使用val或var修饰，
 * 所以它们只是构造函数的参数，不是类的属性。
 * 这些参数只能在构造函数中使用，或传递给父类构造函数，
 * 但不能在类的其他方法中直接访问。
 */
class SmartTvDevice(deviceName:String, deviceCategory:String):SmartDevice(name=deviceName, category=deviceCategory){

  // 覆盖父类的deviceType属性，将其值设置为"Smart TV"
  override val deviceType = "Smart TV"

  /**
   * 扬声器音量属性，初始值为2
   * 自定义setter方法，确保音量值在0到100之间
   */
  var speakerVolume = 2
  set(value) {
    // 检查音量值是否在有效范围内
    if (value in 0..100) {
      // field是幕后字段，引用属性本身的值
      field = value
    }
    // 如果值无效，不做任何操作，保持原值不变
  }

  /**
   * 频道号属性，初始值为1
   * 自定义setter方法，确保频道号在0到200之间
   */
  var channelNumber = 1
  set(value) {
    // 检查频道号是否在有效范围内
    if (value in 0..200) {
      field = value
    }
    // 如果值无效，不做任何操作，保持原值不变
  }

  /**
   * 增加扬声器音量的方法
   * 将音量值加1并打印新的音量值
   */
  fun increaseSpeakerVolume() {
    speakerVolume++
    println("Speaker volume increased to $speakerVolume.")
  } 

  /**
   * 切换到下一个频道的方法
   * 将频道号加1并打印新的频道号
   */
  fun nextChannel() {
    channelNumber++
    println("Channel number increased to $channelNumber.")
  }

  /**
   * 覆盖父类的turnOn方法
   * 首先调用父类的turnOn方法，然后执行自己的逻辑
   */
  override fun turnOn() {
    // 调用父类的turnOn方法，设置deviceStatus为"on"
    super.turnOn()
    // 打印设备开启信息，包括设备名称、音量和频道号
    println(
        "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
            "set to $channelNumber."
    )
  }

  /**
   * 覆盖父类的turnOff方法
   * 首先调用父类的turnOff方法，然后执行自己的逻辑
   */
  override fun turnOff() {
    // 调用父类的turnOff方法，设置deviceStatus为"off"
    super.turnOff()
    // 打印设备关闭信息
    println("$name turned off")
  }
}

/**
 * SmartLightDevice - 智能灯光设备类
 * 继承自SmartDevice基类
 */
class SmartLightDevice(deviceName: String, deviceCategory: String):SmartDevice(name = deviceName, category = deviceCategory) {
  
  // 覆盖父类的deviceType属性，将其值设置为"Smart Light"
  override val deviceType = "Smart Light"
  
  /**
   * 亮度级别属性，初始值为0
   * 自定义setter方法，确保亮度值在0到100之间
   */
  var brightnessLevel = 0
  set(value) {
    // 检查亮度值是否在有效范围内
    if (value in 0..100) {
      field = value
    }
    // 如果值无效，不做任何操作，保持原值不变
  }

  /**
   * 增加亮度的方法
   * 将亮度值加1并打印新的亮度值
   */
  fun increaseBrightness() {
    brightnessLevel++
    println("Brightness increased to $brightnessLevel.")
  }

  /**
   * 覆盖父类的turnOn方法
   * 首先调用父类的turnOn方法，然后执行自己的逻辑
   */
  override fun turnOn() {
    // 调用父类的turnOn方法，设置deviceStatus为"on"
    super.turnOn()
    // 设置初始亮度为2
    brightnessLevel = 2
    // 打印设备开启信息，包括设备名称和亮度级别
    println("$name turned on. The brightness level is $brightnessLevel.")
  }

  /**
   * 覆盖父类的turnOff方法
   * 首先调用父类的turnOff方法，然后执行自己的逻辑
   */
  override fun turnOff() {
    // 调用父类的turnOff方法，设置deviceStatus为"off"
    super.turnOff()
    // 关闭设备时将亮度设置为0
    brightnessLevel = 0
    // 打印设备关闭信息
    println("Smart Light turned off")
  }
}

/**
 * SmartHome - 智能家居类
 * 这个类组合了智能电视和智能灯光设备，实现了对多个设备的集中控制
 * 这是组合(Composition)的示例，SmartHome有一个SmartTvDevice和一个SmartLightDevice
 * 
 * @param smartTvDevice 智能电视设备实例
 * @param smartLightDevice 智能灯光设备实例
 */
class SmartHome(
  // 使用val声明为只读属性
  val smartTvDevice: SmartTvDevice,
  val smartLightDevice: SmartLightDevice
  ) {
  /**
   * 打开电视的方法
   * 委托给smartTvDevice的turnOn方法
   */
  fun turnOnTv() {
    smartTvDevice.turnOn()
  }

  /**
   * 关闭电视的方法
   * 委托给smartTvDevice的turnOff方法
   */
  fun turnOffTv() {
    smartTvDevice.turnOff()
  }

  /**
   * 增加电视音量的方法
   * 委托给smartTvDevice的increaseSpeakerVolume方法
   */
  fun increaseTvVolume() {
    smartTvDevice.increaseSpeakerVolume()
  }

  /**
   * 切换到下一个电视频道的方法
   * 委托给smartTvDevice的nextChannel方法
   */
  fun changeTvChannelToNext() {
    smartTvDevice.nextChannel()
  }

  /**
   * 打开灯光的方法
   * 委托给smartLightDevice的turnOn方法
   */
  fun turnOnLight() {
    smartLightDevice.turnOn()
  }

  /**
   * 关闭灯光的方法
   * 委托给smartLightDevice的turnOff方法
   */
  fun turnOffLight() {
    smartLightDevice.turnOff()
  }

  /**
   * 增加灯光亮度的方法
   * 委托给smartLightDevice的increaseBrightness方法
   */
  fun increaseLightBrightness() {
    smartLightDevice.increaseBrightness()
  }

  /**
   * 关闭所有设备的方法
   * 调用自身的方法关闭电视和灯光
   */
  fun turnOffAllDevices() {
    turnOffTv()
    turnOffLight()
  }
}

/**
 * 主函数 - 程序入口点
 * 演示多态性(Polymorphism)的应用
 */
fun main() {
  // 声明一个SmartDevice类型的变量，但实际引用SmartTvDevice对象
  // 这是多态的体现：父类引用指向子类对象
  var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
  // 调用turnOn方法，实际执行的是SmartTvDevice的turnOn方法
  smartDevice.turnOn()
  
  // 将同一个变量重新赋值为SmartLightDevice对象
  smartDevice = SmartLightDevice("Google Light", "Utility")
  // 调用turnOn方法，实际执行的是SmartLightDevice的turnOn方法
  // 这也是多态的体现：同一个引用在不同时刻指向不同的对象，调用同名方法有不同的行为
  smartDevice.turnOn()
}