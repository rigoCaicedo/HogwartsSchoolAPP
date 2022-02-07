package com.hogwarts.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown=true)
public class Estudiante {
    private long id;
    private String nombre;
    private String apellido;
    private long identificacion;
    private long casa_id;
}
