package es.neifi.model;

import es.neifi.view.ClientsManagement;
import es.neifi.view.OrdersManagement;

public class DependencyInjection {
	
	ClientsManagement cliMng;
	OrdersManagement ordMng;
	PostgresSQLOrders psqlOrders;
	PostgresSQLOrderList psqlOrderList;
	XmlReader xmlReade;
	public DependencyInjection(ClientsManagement climng, OrdersManagement ordMng) {
		this.cliMng = climng;
		this.ordMng = ordMng;
	}
	public DependencyInjection(PostgresSQLOrders psqlOrders, PostgresSQLOrderList psqlOrderList) {
		this.psqlOrderList = psqlOrderList;
		this.psqlOrders = psqlOrders;
	}
	public DependencyInjection(PostgresSQLOrders psqlOrders, PostgresSQLOrderList psqlOrderList, XmlReader xmlReader) {
		this.psqlOrderList = psqlOrderList;
		this.psqlOrders = psqlOrders;
		this.xmlReade = xmlReader;
		
	}
	public DependencyInjection(XmlReader xmlReader) {
		this.xmlReade = xmlReader;
	}
	
	
	public ClientsManagement getCliMng() {
		return cliMng;
	}
	public OrdersManagement getOrdMng() {
		return ordMng;
	}
	public PostgresSQLOrderList getPsqlOrderList() {
		return psqlOrderList;
	}
	public PostgresSQLOrders getPsqlOrders() {
		return psqlOrders;
	}
	public XmlReader getXmlReade() {
		return xmlReade;
	}
	
}
