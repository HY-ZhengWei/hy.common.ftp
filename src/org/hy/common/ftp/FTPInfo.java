package org.hy.common.ftp;

import org.hy.common.Help;





/**
 * FTP信息
 *
 * @author   ZhengWei(HY)
 * @version  V1.0  2012-03-27
 */
public class FTPInfo implements Cloneable
{
	/** 文件服务器IP */
	private String           ip;
	
	/** 文件服务器端口。默认是21 */
	private int              port;
	
	/** 登陆用户名称 */
	private String           user;
	
	/** 登陆密码 */
	private String           password;
	
	/** 连接成功后的初始化目录 */
	private String           initPath;
	
	/** 是否被动模式 */
	private boolean          isPassiveMode;  
	
	/** 安全接口 */
	private FTPSecurity      security;
	
	
	
	public FTPInfo()
	{
		this("" ,21 ,"" ,"");
	}
	
	
	
	/**
	 * 构造器
	 * 
	 * @param i_FTPIP         文件服务器IP
	 * @param i_FTPPort       文件服务器端口。默认是21
	 * @param i_FTPUser       登陆用户名称
	 * @param i_FTPPassword   登陆密码
	 */
	public FTPInfo(String i_IP ,int i_Port ,String i_User ,String i_Password)
	{
		this.setIp(      i_IP);
		this.setPort(    i_Port);
		this.setUser(    i_User);
		this.setPassword(i_Password);
	}



	public String getIp() 
	{
		return ip;
	}



	public void setIp(String ip) 
	{
		this.ip = ip;
	}
	
	
	
	public String getPasswordValue()
	{
		return this.password;
	}
	
	
	
	public String getPassword() 
	{
		if ( this.security != null && !Help.isNull(this.user) )
		{
			if ( Help.isNull(this.password) )
			{
				return "";
			}
			else
			{
				return this.security.getDecrypt(this.password, this.user);
			}
		}
		else
		{
			return this.password;
		}
	}



	public void setPassword(String i_Password) 
	{
		if (  this.security != null && !Help.isNull(this.user) )
		{
			if ( i_Password != null )
			{
				if ( i_Password.trim().length() == this.security.getSecurityLen())
				{
					this.password  = i_Password;
				}
				else
				{
					this.password  = this.security.getEncrypt(i_Password ,this.user);
				}
			}
			else
			{
				this.password = i_Password;
			}
		}
		else
		{
			this.password = i_Password;
		}
	}



	public int getPort() 
	{
		return port;
	}



	public void setPort(int port) 
	{
		this.port = port;
	}



	public String getUser()
	{
		return user;
	}


	
	public void setUser(String user) 
	{
		this.user = user;
	}



	public String getInitPath() 
	{
		return Help.NVL(initPath ,"/");
	}
	
	
	
	public void setInitPath(String initPath) 
	{
		this.initPath = initPath;
	}



	public boolean isPassiveMode() 
	{
		return isPassiveMode;
	}



	public void setPassiveMode(boolean isPassiveMode) 
	{
		this.isPassiveMode = isPassiveMode;
	}
	
	
	
	public FTPSecurity getSecurity() 
	{
		return security;
	}
	
	
	
	public void setSecurity(FTPSecurity security) 
	{
		this.security = security;
	}
	
	
	
	/**
	 * 克隆
	 */
	public FTPInfo clone() 
	{
		FTPInfo v_Clone = new FTPInfo(this.ip ,this.port ,this.user ,this.password);
		
		v_Clone.setPassiveMode(this.isPassiveMode);
		v_Clone.setInitPath(this.initPath);
		
		return v_Clone;
	}
	
}
