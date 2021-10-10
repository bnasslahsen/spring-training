package spring.annotations;

import org.springframework.stereotype.Component;

@Component("serviceMachin")
public class ServiceMachinImpl implements ServiceMachin {

	private SousServiceTruc m_serviceTruc;
	private String m_monParametre = "default value";

	public ServiceMachinImpl(SousServiceTruc m_serviceTruc) {
		this.m_serviceTruc = m_serviceTruc;
	}

	@Override
	public String getMonParametre() {
		return m_monParametre;
	}

	public void setMonParametre(String _monParametre) {
		m_monParametre = _monParametre;
	}

	@Override
	public void faireMachin() {
		System.out.println("travail dans le service Machin");
		m_serviceTruc.faireTruc();
	}
}
