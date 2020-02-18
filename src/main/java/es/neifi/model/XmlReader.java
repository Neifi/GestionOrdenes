package es.neifi.model;

import java.io.File;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XmlReader {

	private String clientId;

	private String articleId;
	private String qty;
	private String servedUnits;
	private String status;
	private String orderId;
	private String lineStatus;
	private String price;
	private int orderListId;

	ArrayList<OrderList> orderListArray = new ArrayList<OrderList>();
	ArrayList<Order> ordersArray = new ArrayList<Order>();

	public XmlReader() {
		start();
	}

	private void start() {
		try {

			System.out.println("[INFO] Reading xml");
			File inputFile = new File("test.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList orders = doc.getElementsByTagName("order");

			for (int i = 0; i < orders.getLength(); i++) {

				Node nNode = orders.item(i);

				Element ordersElement = (Element) nNode;

				NodeList nList2 = orders.item(i).getChildNodes();

				orderListId = 0;

				status = ordersElement.getAttribute("status");

				orderId = ordersElement.getAttribute("orderId");
				clientId = ordersElement.getAttribute("clientId");

				System.out.println("[INFO] orderID: " + orderId + " clientID: " + clientId + " Status: " + status);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					for (int temp = 0; temp < nList2.getLength(); temp++) {

						Node nNode2 = nList2.item(temp);

						if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

							orderListId++;

							Element eElement = (Element) nNode2;
							
							articleId = eElement.getElementsByTagName("article_id").item(0).getTextContent();
							qty = eElement.getElementsByTagName("quantity").item(0).getTextContent();
							price = eElement.getElementsByTagName("price").item(0).getTextContent();
							
							servedUnits = eElement.getElementsByTagName("servedUnits").item(0).getTextContent();
							lineStatus = eElement.getElementsByTagName("status").item(0).getTextContent();

							System.out.println("[INFO] lineId: " + orderListId);

							orderListArray.add(new OrderList(orderId,articleId, qty, Integer.parseInt(price),status, servedUnits));

						}

					}

				}

				if (ordersElement.getAttribute("status").equals("0")) {
					System.out.println("0");
					ordersArray.add(new Order(clientId, orderId, status));

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<OrderList> getOrderListArray() {
		return orderListArray;
	}

	public ArrayList<Order> getOrdersArray() {
		return ordersArray;
	}

}