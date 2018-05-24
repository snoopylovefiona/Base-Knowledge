package com.snoopy.demo;

/**
 * 
 * 类名称：BaseTypeDefaultValue.java <br>
 * 内容摘要： //基本类型默认值。<br>
 * 修改备注： <br>
 * 创建时间： 2018年5月24日上午10:20:27<br>
 * 
 * @author Snoopy.Li<br>
 */
public class BaseTypeDefaultValue {

	int intValue;

	Integer integerValue;

	double doubleValue;

	Double doubleValue_;

	boolean booleanValue;

	Boolean booleanValue_;

	char charValue;

	Character characterValue;

	float floatValue;

	Float floatValue_;

	byte byteValue;

	Byte byteValue_;

	long longValue;

	Long longValue_;

	short shortValue;

	Short shortValue_;

	public static void main(String args[]) {

		BaseTypeDefaultValue baseTypeDefaultValue = new BaseTypeDefaultValue();

		System.out.println("整型的默认值是：" + baseTypeDefaultValue.intValue);
		System.out.println("双精度浮点型的默认值是：" + baseTypeDefaultValue.doubleValue);
		System.out.println("布尔型的默认值是：" + baseTypeDefaultValue.booleanValue);
		System.out.println("字符型的默认值是：" + baseTypeDefaultValue.charValue);
		System.out.println("byte的默认值是：" + baseTypeDefaultValue.floatValue);
		System.out.println("单精度浮点型的默认值是：" + baseTypeDefaultValue.byteValue);
		System.out.println("短整型的默认值是：" + baseTypeDefaultValue.longValue);
		System.out.println("长整型的默认值是：" + baseTypeDefaultValue.shortValue);

		System.out.println("----------------------------------------");

		System.out.println("整型的默认值是：" + baseTypeDefaultValue.integerValue);
		System.out.println("双精度浮点型的默认值是：" + baseTypeDefaultValue.doubleValue_);
		System.out.println("布尔型的默认值是：" + baseTypeDefaultValue.booleanValue_);
		System.out.println("字符型的默认值是：" + baseTypeDefaultValue.characterValue);
		System.out.println("byte的默认值是：" + baseTypeDefaultValue.floatValue_);
		System.out.println("单精度浮点型的默认值是：" + baseTypeDefaultValue.byteValue_);
		System.out.println("短整型的默认值是：" + baseTypeDefaultValue.longValue_);
		System.out.println("长整型的默认值是：" + baseTypeDefaultValue.shortValue_);

		/**
		 * 结论<br>
		 * 
		 * 封装类型的默认值都是null
		 * 
		 */

	}
}
