package edu.iot.common.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Money {
	private String money1000;
	private String money5000;
	private String money10000;
	private String money50000;
	private String cash1;
	private String sum;
}
