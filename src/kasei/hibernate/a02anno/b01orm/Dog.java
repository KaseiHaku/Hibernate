package kasei.hibernate.a02anno.b01orm;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity // 指明这个类和数据库中的表对应
@Table(name = "a02b01_Dog", uniqueConstraints = { @UniqueConstraint(columnNames = { "dogName" }) })
@SequenceGenerator(name = "generatorName1", sequenceName = "seqName")
/*
 * @SequenceGenerator 设置一个序列 id 生成器 name 属性： 该 id 生成器的名字 sequenceName 属性：配置数据库中
 * sequence 的名字
 */
@TableGenerator( // 设置一个表 id 生成器，应用场景：跨数据库平台
		name = "generatorName2", // 该 id 生成器的名字
		table = "h001GenTab", // 用于生成 id 的生成表的表名
		pkColumnName = "pk_key", // id 生成表中，表示主键的列名
		valueColumnName = "pk_value", // id 生成表中，表示值的列名
		pkColumnValue = "a02b01_Dog", // id 生成表中，用于本映射 id 生成的主键列的记录名
		initialValue = 1, // 设置初始值 = 1
		allocationSize = 2 // 设置步进值 = 2
)
public class Dog {

	private Integer id; // 数字
	private String name; // 字符串
	private Date birthday; // 日期
	private Color color; // enum
	private DogProperties dogProperties; // 组件
	private String anonymous; // 该属性不做映射处理

	@Id // 指明数据库主键:必须放在get方法上
	@GeneratedValue(generator = "generatorName2")
	// @GenericGenerator(name = "uuid", strategy = "uuid") // 配置主键自动生成uuid
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Basic // 默认添加的注解
	@Column(name = "dogName") // 指定映射到数据库中的列名为 dogName
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE) // 声明该属性为日期类型且只保存日期
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Enumerated(EnumType.ORDINAL) // 该注解表示该字段是枚举类型，参数表示存序号
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Embedded // 表示该属性为组件，数据库建表时两个类的字段会创建到一张表上
	public DogProperties getDogProperties() {
		return dogProperties;
	}

	public void setDogProperties(DogProperties dogProperties) {
		this.dogProperties = dogProperties;
	}

	@Transient // 表明此字段在数据库里面没有对应列，在如果才一个能xml配置，直接不写这个字段就行
	public String getAnonymous() {
		return anonymous;
	}

	public void setAnonymous(String anonymous) {
		this.anonymous = anonymous;
	}
}
