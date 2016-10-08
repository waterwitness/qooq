package com.tencent.mobileqq.dating;

import android.database.Cursor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.utils.HexUtil;
import tencent.im.oidb.cmd0x683.cmd0x683.GodInfo;

public class GodEntity
  extends Entity
{
  public int age;
  public int chatflag;
  public String chatsig;
  public String constellation;
  public String cookie;
  public String declaration;
  public String distance;
  public int gender;
  public int listType;
  public int marriage;
  public String nickName;
  public int praiseCount;
  public int praiseflag;
  public int profession;
  public int recommend;
  @unique
  public long tinyId;
  public String uin;
  public String url;
  public String vipInfo;
  
  public GodEntity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean canSayHi()
  {
    return this.chatflag == 1;
  }
  
  protected boolean entityByCursor(Cursor paramCursor)
  {
    this.tinyId = paramCursor.getLong(paramCursor.getColumnIndex("tinyId"));
    this.nickName = paramCursor.getString(paramCursor.getColumnIndex("nickName"));
    this.declaration = paramCursor.getString(paramCursor.getColumnIndex("declaration"));
    this.age = paramCursor.getInt(paramCursor.getColumnIndex("age"));
    this.gender = paramCursor.getInt(paramCursor.getColumnIndex("gender"));
    this.constellation = paramCursor.getString(paramCursor.getColumnIndex("constellation"));
    this.profession = paramCursor.getInt(paramCursor.getColumnIndex("profession"));
    this.distance = paramCursor.getString(paramCursor.getColumnIndex("distance"));
    this.marriage = paramCursor.getInt(paramCursor.getColumnIndex("marriage"));
    this.vipInfo = paramCursor.getString(paramCursor.getColumnIndex("vipInfo"));
    this.recommend = paramCursor.getInt(paramCursor.getColumnIndex("recommend"));
    this.chatflag = paramCursor.getInt(paramCursor.getColumnIndex("chatflag"));
    this.praiseflag = paramCursor.getInt(paramCursor.getColumnIndex("praiseflag"));
    this.praiseCount = paramCursor.getInt(paramCursor.getColumnIndex("praiseCount"));
    this.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
    this.chatsig = paramCursor.getString(paramCursor.getColumnIndex("chatsig"));
    this.listType = paramCursor.getInt(paramCursor.getColumnIndex("listType"));
    this.url = paramCursor.getString(paramCursor.getColumnIndex("url"));
    this.cookie = paramCursor.getString(paramCursor.getColumnIndex("cookie"));
    return true;
  }
  
  public void init(cmd0x683.GodInfo paramGodInfo, int paramInt)
  {
    if (paramGodInfo.uint64_tinyid.has()) {
      this.tinyId = paramGodInfo.uint64_tinyid.get();
    }
    if (paramGodInfo.bytes_nickname.has()) {
      this.nickName = paramGodInfo.bytes_nickname.get().toStringUtf8();
    }
    if (paramGodInfo.uint32_age.has()) {
      this.age = paramGodInfo.uint32_age.get();
    }
    if (paramGodInfo.uint32_gender.has()) {
      this.gender = paramGodInfo.uint32_gender.get();
    }
    if (paramGodInfo.str_constellation.has()) {
      this.constellation = paramGodInfo.str_constellation.get();
    }
    if (paramGodInfo.uint32_profession.has()) {
      this.profession = paramGodInfo.uint32_profession.get();
    }
    if (paramGodInfo.str_distance.has()) {
      this.distance = paramGodInfo.str_distance.get();
    }
    if (paramGodInfo.uint32_marriage.has()) {
      this.marriage = paramGodInfo.uint32_marriage.get();
    }
    if (paramGodInfo.str_vipinfo.has()) {
      this.vipInfo = paramGodInfo.str_vipinfo.get();
    }
    if (paramGodInfo.uint32_recommend.has()) {
      this.recommend = paramGodInfo.uint32_recommend.get();
    }
    if (paramGodInfo.uint32_chatflag.has()) {
      this.chatflag = paramGodInfo.uint32_chatflag.get();
    }
    if (paramGodInfo.uint64_uin.has()) {
      this.uin = (paramGodInfo.uint64_uin.get() + "");
    }
    if (paramGodInfo.bytes_chatsig.has()) {
      this.chatsig = HexUtil.a(paramGodInfo.bytes_chatsig.get().toByteArray());
    }
    if (paramGodInfo.bytes_declaration.has()) {
      this.declaration = paramGodInfo.bytes_declaration.get().toStringUtf8();
    }
    if (paramGodInfo.uint32_praisecount.has()) {
      this.praiseCount = paramGodInfo.uint32_praisecount.get();
    }
    if (paramGodInfo.bytes_praise_cookies.has()) {
      this.cookie = paramGodInfo.bytes_praise_cookies.get().toStringUtf8();
    }
    if (paramGodInfo.uint32_praiseflag.has()) {
      this.praiseflag = paramGodInfo.uint32_praiseflag.get();
    }
    this.listType = paramInt;
  }
  
  public boolean praised()
  {
    return this.praiseflag == 1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\dating\GodEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */