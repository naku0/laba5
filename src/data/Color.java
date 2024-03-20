package data;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Color")
@XmlEnum
public enum Color {
    @XmlEnumValue("GREEN")
    GREEN,
    @XmlEnumValue("RED")
    RED,
    @XmlEnumValue("YELLOW")
    YELLOW,
    @XmlEnumValue("BROWN")
    BROWN;

}

