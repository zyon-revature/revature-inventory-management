package com.revature.Inventory.model;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Threshold {
	private @Getter @Setter String title;
	private @Getter @Setter int demand;
	
}
