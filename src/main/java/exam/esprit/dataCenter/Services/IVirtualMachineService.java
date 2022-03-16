package exam.esprit.dataCenter.Services;

import exam.esprit.dataCenter.Entities.VirtualMachine;

public interface IVirtualMachineService {

	
	int ajouterVm(VirtualMachine vm);
	void affecterVmUser(int idVm, int idUser);
	void affecterVm(int idVm);
	void demarrerInstanceUser(int idVm);
	void arreterInstanceUser(int idVm);
	
}
