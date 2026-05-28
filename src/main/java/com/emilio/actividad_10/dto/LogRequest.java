package com.emilio.actividad_10.dto;

import com.emilio.actividad_10.model.LogLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogRequest {
    private String appId;
    private LogLevel logLevel;
    private String message;
}