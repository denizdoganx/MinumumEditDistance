package dal;

import java.util.ArrayList;

import model.MED;
import model.MedMatrixObject;
import model.MedObject;
import util.R;

public class MedDal {

	private static MedDal instance = null;

	private MedDal() {
	}
	
	public static MedDal getInstance() {
		
		if(instance == null) {
			instance = new MedDal();
		}
		return instance;
	}
	
	public MedObject[] executeForNItemWithGivenWord(String word, int n) {
		
		MedObject[] retArr = new MedObject[n];
		ArrayList<MedObject> alternativeCorrectWords = new ArrayList<>();
		MED tempMed = null;
		MedObject tempMedObject = null;
		int tempMeasurementOfMed;
	
		for(String line : R.lines) {
			tempMed = new MED(word, line);
			tempMeasurementOfMed = tempMed.getMinumumEditDistance();
			tempMedObject = new MedObject(line, tempMeasurementOfMed);
			alternativeCorrectWords.add(tempMedObject);
		}
		
		
		for(int i = 0;i < n; i++) {
			MedObject candidate = alternativeCorrectWords.get(0);
			for(MedObject m : alternativeCorrectWords) {
				if(candidate.getMed() > m.getMed()) {
					candidate = m;
				}
			}
			retArr[i] = candidate;
			alternativeCorrectWords.remove(candidate);
		}
		return retArr;
	}
	
	public MedMatrixObject executeForMedTable(String source, String target) {
		MED med = new MED(source, target);
		return new MedMatrixObject(med.getMinumumEditDistance(), med.getMedMatrix(), med.getPath());
	}
}
