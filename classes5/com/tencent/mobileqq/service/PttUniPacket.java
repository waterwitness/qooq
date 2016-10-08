package com.tencent.mobileqq.service;

import com.qq.jce.wup.UniPacket;
import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public class PttUniPacket
  extends UniPacket
{
  public static String a;
  JceOutputStream a;
  JceOutputStream b;
  JceOutputStream c;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = PttUniPacket.class.getSimpleName();
  }
  
  public PttUniPacket(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public byte[] encode()
  {
    if (this._package.iVersion == 2)
    {
      if ((this._package.sServantName == null) || (this._package.sServantName.equals(""))) {
        throw new IllegalArgumentException("servantName can not is null");
      }
      if ((this._package.sFuncName == null) || (this._package.sFuncName.equals(""))) {
        throw new IllegalArgumentException("funcName can not is null");
      }
    }
    else
    {
      if (this._package.sServantName == null) {
        this._package.sServantName = "";
      }
      if (this._package.sFuncName == null) {
        this._package.sFuncName = "";
      }
    }
    if (this.jdField_a_of_type_ComQqTafJceJceOutputStream == null)
    {
      this.jdField_a_of_type_ComQqTafJceJceOutputStream = new JceOutputStream(0);
      this.jdField_a_of_type_ComQqTafJceJceOutputStream.setServerEncoding(this.encodeName);
      if ((this._package.iVersion != 2) && (this._package.iVersion != 1)) {
        break label304;
      }
      this.jdField_a_of_type_ComQqTafJceJceOutputStream.write(this._data, 0);
      label184:
      this._package.sBuffer = JceUtil.getJceBufArray(this.jdField_a_of_type_ComQqTafJceJceOutputStream.getByteBuffer());
      if (this.b != null) {
        break label319;
      }
      this.b = new JceOutputStream(0);
    }
    for (;;)
    {
      this.b.setServerEncoding(this.encodeName);
      writeTo(this.b);
      int i = this.b.getByteBuffer().position();
      Object localObject = ByteBuffer.allocate(i + 4);
      ((ByteBuffer)localObject).putInt(i + 4);
      localObject = ((ByteBuffer)localObject).array();
      System.arraycopy(this.b.getByteBuffer().array(), 0, localObject, 4, i);
      return (byte[])localObject;
      this.jdField_a_of_type_ComQqTafJceJceOutputStream.getByteBuffer().clear();
      break;
      label304:
      this.jdField_a_of_type_ComQqTafJceJceOutputStream.write(this._newData, 0);
      break label184;
      label319:
      this.b.getByteBuffer().clear();
    }
  }
  
  public void put(String paramString, Object paramObject)
  {
    if (this._newData != null)
    {
      if (paramString == null) {
        throw new IllegalArgumentException("put key can not is null");
      }
      if (paramObject == null) {
        throw new IllegalArgumentException("put value can not is null");
      }
      if ((paramObject instanceof Set)) {
        throw new IllegalArgumentException("can not support Set");
      }
      if (this.c == null) {
        this.c = new JceOutputStream();
      }
      for (;;)
      {
        this.c.setServerEncoding(this.encodeName);
        this.c.write(paramObject, 0);
        paramObject = JceUtil.getJceBufArray(this.c.getByteBuffer());
        this._newData.put(paramString, paramObject);
        return;
        this.c.getByteBuffer().clear();
      }
    }
    super.put(paramString, paramObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\service\PttUniPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */