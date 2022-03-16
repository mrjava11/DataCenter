package exam.esprit.dataCenter.Services;

import java.util.List;

import exam.esprit.dataCenter.Entities.DataCenter;

public interface IDataCenterService {

	void ajouterDc(DataCenter dataCenter);
	List<DataCenter> listerDataCenter();
}
