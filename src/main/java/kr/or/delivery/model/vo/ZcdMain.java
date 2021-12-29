package kr.or.delivery.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZcdMain {
	private int storeNo;
	private String storeName;
	private int minPrice;
	private String filename;
	private String filepath;
}
