package database;

import java.util.List;

public class DataBaseDirector {

	private DataBaseBuilder b;
	List<data.Section> sections;

	public DataBaseDirector() {

		b = new DataBaseBuilder();
		
		/*
		  b.insertSection("C40",  40,  20, 5, 5, 5, 3.51, 7.26, 1.06, 1.44, 0.55, 0.78);
			b.insertSection("C50",  50,  38, 7, 5, 7, 7.12, 26.4, 9.12, 1.92, 1.13, 3.75);
			b.insertSection("C65",  65,  42, 7.5, 5.5, 7.5, 9.03, 57.5, 14.1, 2.52, 1.25, 5.07);
			b.insertSection("C80",  80,  45, 8, 6, 8, 11, 106, 19.4, 3.10, 1.33, 6.36);
			b.insertSection("C100", 100, 50, 8.5, 6, 8.5, 13.5, 206, 29.3, 3.91, 1.47, 8.49);
			b.insertSection("C120", 120, 55, 9, 7, 9, 17, 364, 43.2, 4.62, 1.59, 11.1);
			b.insertSection("C140", 140, 60, 10, 7, 10, 20.4, 605, 62.7, 5.45, 1.75, 14.8);
			b.insertSection("C160", 160, 65, 10.5, 7.5, 10.5, 24, 925, 85.3, 6.21, 1.89, 18.3);
			b.insertSection("C180", 180, 70, 11, 8, 11, 28, 1350, 114, 6.95, 2.02, 22.4);
			b.insertSection("C200", 200, 75, 11.5, 8.5, 11.5, 32.2, 1910, 148, 7.70, 2.14, 27.0);
			b.insertSection("C220", 220, 80, 12.5, 9.0, 12.5, 37.4, 2690, 197, 8.48, 2.30, 33.6);
			b.insertSection("C240", 240, 85, 13.0, 9.5, 13.0, 42.3, 3600, 248, 9.22, 2.42, 39.6);
			b.insertSection("C260", 260, 90, 14.0, 10.0, 14.0, 48.3, 4820, 317, 9.99, 2.56, 47.7);
			b.insertSection("C280", 280, 95, 15.0, 10.0, 15.0, 53.3, 6280, 399, 10.9, 2.74, 57.2);
			b.insertSection("C300", 300, 100,16.0, 10.0, 16.0, 58.8, 8030, 495, 11.7, 2.90, 67.8);
			b.insertSection("C320", 320, 100, 17.5, 14.0, 17.5, 75.8, 10870, 597, 12.1, 2.81, 80.6);
			b.insertSection("C350", 350, 100, 16.0, 14.0, 16.0, 77.3, 12840, 570, 12.9, 2.72, 75.0);
			b.insertSection("C380", 380, 102, 16.0, 13.5, 16.0, 80.4, 15760, 615, 14.0, 2.77, 78.7);
			b.insertSection("C400", 400, 110, 18.0, 14.0, 18.0, 91.5, 20350, 846, 14.9, 3.04, 102);
		 
			b.insertSection("IPE80", 80, 46, 5.2, 3.8, 5, 7.64, 80.1, 8.49, 3.24, 1.05, 3.69);
			b.insertSection("IPE100", 100, 55, 5.7, 4.1, 7, 10.3, 171, 15.9, 4.07, 1.24, 5.79);
			b.insertSection("IPE120", 120, 64, 6.3, 4.4, 7, 13.2, 318, 27.7, 4.90, 1.45, 8.65);
			b.insertSection("IPE140", 140, 73, 6.9, 4.7, 7, 16.4, 541, 44.9, 5.74, 1.65, 12.3);
			b.insertSection("IPE160", 160, 82, 7.4, 5.0, 9, 23.9, 869, 68.3, 6.58, 1.84, 16.7);
			b.insertSection("IPE180", 180, 91, 8.0, 5.3, 9, 23.9,1320,  101, 7.42, 2.05, 22.2);
			b.insertSection("IPE200", 200,100, 8.5, 5.6,12, 28.5,1940,  142, 8.26, 2.24, 28.4);
			b.insertSection("IPE220", 220,110, 9.2, 5.9,12, 33.4,2770,  205, 9.11, 2.48, 37.3);
			b.insertSection("IPE240", 240,120, 9.8, 6.2,15, 39.1,3890,  284, 9.97, 2.69, 47.7);
			b.insertSection("IPE270", 270,135,10.2, 6.6,15, 45.9,5790,  420, 11.2, 3.02, 62.2);
			b.insertSection("IPE300", 300,150,10.7, 7.1,15, 53.8,8360,  604, 12.5, 3.35, 80.5);
			b.insertSection("IPE330", 330,160,11.5, 7.5,18, 62.6,11770, 788, 13.7, 3.55, 98.5);
			b.insertSection("IPE360", 360,170,12.7, 8.0,18, 72.7,16270,1040, 15.0, 3.79, 123);
			b.insertSection("IPE400", 400,180,13.5, 8.6,21, 84.5,23130,1320, 16.5, 3.95, 146);
			b.insertSection("IPE450", 450,190,14.6, 9.4,21, 98.8,33740,1680, 18.5, 4.12, 176);
			b.insertSection("IPE500", 500,200,16.0,10.2,21, 116, 48200,2140, 20.4, 4.31, 214);
			b.insertSection("IPE550", 550,210,17.2,11.1,24, 134, 67120,2670, 22.3, 4.45, 254);
			b.insertSection("IPE600", 600,220,19.0,12,24, 156, 92080, 3390, 24.3, 4.66, 308);
		*/	
		
		 this.sections = b.selectSection("SELECT * FROM sections ");

		 for (int i=0; i<37 ; i++)
			 System.out.println(sections.get(i).getName());
		 b.closeConnection();
	
	}
	
	
	
	public data.Section insert(String name){
	
		for(int i=0;i<100;i++)
			if (sections.get(i).getName().equals(name)) {
				return sections.get(i);
			}
		
		return null;
		
	}
	
}
