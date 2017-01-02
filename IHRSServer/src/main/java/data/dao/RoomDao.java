package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ListPO;
import po.RoomPO;

public interface RoomDao extends java.rmi.Remote {
	
	/**
	 * @param hotelId  酒店编号
	 * @return         获取对应酒店的所有房间信息
	 * @throws RemoteException
	 */
	public ArrayList<RoomPO> getRoomsByHotel(int hotelId) throws RemoteException;
	
	/**
	 * @param listId  订单编号
	 * @return        对应订单里的所有房间信息
	 * @throws RemoteException
	 */
	public ArrayList<RoomPO> getRoomByList(int listId) throws RemoteException;
	
	/**
	 * @param roomPO  房间信息
	 * @return        是否添加成功
	 * @throws RemoteException
	 */
	public boolean addRoom(RoomPO roomPO) throws RemoteException;
	
	/**
	 * @param roomPO  房间信息
	 * @return        是否修改成功（在RoomTxt中）
	 * @throws RemoteException
	 */
	public boolean updateRoom(RoomPO roomPO) throws RemoteException;
	
	/**
	 * @param listPO  订单信息
	 * @param rooms   订单中的房间信息
	 * @return        是否修改成功（在RoomInListTxt中）
	 */
	public boolean updateRoom(ListPO listPO,ArrayList<RoomPO> rooms) throws RemoteException;
	
}
