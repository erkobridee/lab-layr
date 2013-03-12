package home;

import java.util.Date;

import javax.ejb.Stateless;

@Stateless
public class ProfileMeasurer {

	public long measurer() {
		return new Date().getTime() % 2;
	}
	
}
