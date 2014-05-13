package net.github.rtc.app.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Vladislav Pikus
 */
@XmlRootElement
public enum RoleTypes {
    ROLE_USER, ROLE_ADMIN, ROLE_EXPERT;
}