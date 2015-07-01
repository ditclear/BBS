package bbs.vienan.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class DateConverter extends StrutsTypeConverter {
	private  final DateFormat[] dfs = {		
			new SimpleDateFormat("yyyy.MM.dd"),
			new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyy/MM/dd") }; 
	public Object convertFromString (Map context, String[] values, 
			Class toType) {
		String dateStr = values[0];// ��ȡ���ڵ��ַ�
		for (int i=0;i<dfs.length;i++) {// ��������֧�ָ�ʽ������ת��
			try {
				return dfs[i].parse(dateStr);
			} catch (Exception e) {				
				continue;
			}		
		}		
		throw new TypeConversionException();		
	}
	public String convertToString (Map context, Object object) {
		Date date = (Date) object;
		// ����ĸ�ʽ��yyyy-MM-dd
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
}
