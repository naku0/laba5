package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Country")
@XmlEnum
public enum Country {
    @XmlEnumValue("SPAIN")
    SPAIN,
    @XmlEnumValue("CHINA")
    CHINA,
    @XmlEnumValue("ITALY")
    ITALY,
    @XmlEnumValue("THAILAND")
    THAILAND;
}