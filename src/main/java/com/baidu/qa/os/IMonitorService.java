package com.baidu.qa.os;

/**
 * @author liangxiaowu
 * 
 */
public interface IMonitorService {
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public MonitorInfoBean getMonitorInfoBean() throws Exception;
    /**
     * 
     * @param processName
     * @return
     * @throws Exception
     */
	public MonitorInfoBean getMonitorInfoBean(String processName) throws Exception;
}
