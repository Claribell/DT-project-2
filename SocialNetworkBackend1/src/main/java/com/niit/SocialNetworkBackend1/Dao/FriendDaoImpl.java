package com.niit.SocialNetworkBackend1.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.SocialNetworkBackend1.model.Friend;

@Repository("friendDao")
public class FriendDaoImpl implements FriendDao {
	
	@Autowired
	public SessionFactory sessionfactory;
	
	public FriendDaoImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;
	}

	@Transactional
	public boolean createFriend(Friend friend) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(friend);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public List<Friend> getAllFriendRequest(String userName) {
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Friend where userName=:uname");
		query.setParameter("uname",userName);
			List<Friend>listFriends=query.list();
			session.close();
			return listFriends;
	}

	@Override
	public List<Friend> getApprovedFriends(String userName) {
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Friend where userName=:uname and status='A'");
		query.setParameter("uname",userName);
			List<Friend>listFriends=query.list();
			session.close();
			return listFriends;
	}

	@Override
	public Friend getFriend(int friendId) {
		Session session=sessionfactory.openSession();
		Friend friend=(Friend) session.get(Friend.class,friendId);
		session.close();
		return friend;
	}

	@Transactional
	public boolean rejectFriendRequest(Friend friend) {
      try {
			friend.setStatus("R");
			sessionfactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception occured:"+e);
		return false;
		}
		
	}

	@Transactional
	public boolean approveFriendRequest(Friend friend) {
		 try {
				friend.setStatus("A");
				sessionfactory.getCurrentSession().update(friend);
				return true;
			}
			catch(Exception e){
				System.out.println("Exception occured:"+e);
			return false;
			}
			
	}

}
