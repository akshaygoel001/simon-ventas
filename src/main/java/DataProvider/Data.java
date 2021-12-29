package DataProvider;

import org.testng.annotations.Test;

public class Data {
	
	
	static ExcelReader data=new ExcelReader(".\\src\\main\\java\\DataProvider\\TestData.xlsx");
	
	
	public static String url=data.getCellData("URL", 0, 1);
	
	public static String clave=data.getCellData("Hogar", 0, 1);
	
	public static String codProducto=data.getCellData("Hogar", 0, 2);
	
	public static String nro_documento=data.getCellData("Hogar", 0, 3);
	
	public static String ciudad=data.getCellData("Hogar", 0, 4);
	
	public static String direccion=data.getCellData("Hogar", 0, 5);
	
	public static String ano_construction=data.getCellData("Hogar", 0, 6);
	
	public static String edifico=data.getCellData("Hogar", 0, 7);
	
	public static String no_electrico=data.getCellData("Hogar", 0, 8);
	
	public static String electrico=data.getCellData("Hogar", 0, 9);
	
	
	
	
	
	
	
	@Test
	public void urldata() {
		System.out.println(edifico+","+no_electrico+","+electrico);
	}
	
	

}
