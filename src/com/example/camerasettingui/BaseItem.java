/*****************************************************************************
 * Copyright (C) 2011 Acer, Inc. All Rights Reserved.
 *
 * This program is an unpublished copyrighted work which is proprietary
 * to Acer, Inc. and contains confidential information that is not to
 * be reproduced or disclosed to any other person or entity without
 * prior written consent from Acer, Inc. in each and every instance.
 *
 * WARNING:  Unauthorized reproduction of this program as well as
 * unauthorized preparation of derivative works based upon the
 * program or distribution of copies by sale, rental, lease or
 * lending are violations of federal copyright laws and state trade
 * secret laws, punishable by civil and criminal penalties.
 *
 *****************************************************************************/
package com.example.camerasettingui;

public class BaseItem {
	private String mKey = "";
	private String mMainText = "";
	private String mSubText = "";
	private int mMainTextResID = -1;
	private int mSubTextResID = -1;
	private int mType = -1;
	private int mListID = -1;

	public void setID(int id) {
		mListID = id;
	}

	public int getID() {
		return mListID;
	}

	public void setType(int type) {
		mType = type;
	}

	public int getType() {
		return mType;
	}

	public void setKey(String key) {
		mKey = key;
	}

	public String getKey() {
		return mKey;
	}

	public void setMainText(String MainText) {
		mMainText = MainText;
	}

	public String getMainText() {
		return mMainText;
	}

	public void setSubText(String SubText) {
		mSubText = SubText;
	}

	public String getSubText() {
		return mSubText;
	}

	public void setMainTextResID(int id) {
		mMainTextResID = id;
	}

	public int getMainTextResID() {
		return mMainTextResID;
	}

	public void setSubTextResID(int id) {
		mSubTextResID = id;
	}

	public int getSubTextResID() {
		return mSubTextResID;
	}
}
