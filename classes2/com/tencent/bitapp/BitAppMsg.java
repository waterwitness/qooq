package com.tencent.bitapp;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.bitapp.pre.ContextUtils;
import com.tencent.bitapp.view.BitAppBaseView;
import com.tencent.bitapp.view.IBitAppBaseViewListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BitAppMsg
  implements Externalizable
{
  public static final int EXPIRED_STATE = -2;
  public static final int FINAL_STATE = -1;
  public static final int FLAG_TAG_COPY = 8;
  public static final int FLAG_TAG_DEFAULT = 0;
  public static final int FLAG_TAG_FORWARD = 1;
  public static final int FLAG_TAG_HEADICON = 4;
  public static final int INIT_STATE = 0;
  public static final String TAG = BitAppMsg.class.getSimpleName();
  public static final int TAG_FAVORITE = 2;
  public static final String XML_NODE_DATA = "data";
  public static final String XML_NODE_ID = "module_id";
  public static final String XML_NODE_ITEM = "item";
  public static final String XML_NODE_MODULE = "module_name";
  public static final String XML_NODE_STATE = "module_state";
  public static final String XML_NODE_VERSION = "module_version";
  public static final int ZIP_MARK_FIRST_BIT_ENCRYPT = -1;
  public static final int ZIP_MARK_NO_BIT_ENCRYPT = 1;
  public static final int ZIP_MARK_NO_ENCRYPT = 0;
  public String adverKey;
  public int adverSign;
  public long mAbility;
  public List mBitAppMsgItemLists = new ArrayList();
  public String mCompatibleText = "";
  public boolean mDataException;
  public byte[] mDecodeXml;
  public int mFlag;
  public int mHeight = -1;
  public String mLolaThumbnail;
  public String mLolaUrl;
  public String mMsgBrief;
  public boolean mMsgException;
  private long mMsgId;
  public int mPaddingBottom = -1;
  public int mPaddingLeft = -1;
  public int mPaddingRight = -1;
  public int mPaddingTop = -1;
  public String mRequiredVersionAndroid = "";
  public BitAppMsgNode mRootNode;
  public int mState = 0;
  public String mThumbNailURl = "";
  int mVersion = 1;
  public int mWidth = -1;
  public byte[] mXml = new byte[0];
  public int mZipMark;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public BitAppMsg() {}
  
  BitAppMsg(byte[] paramArrayOfByte, int paramInt)
  {
    parseXml(paramArrayOfByte, paramInt);
  }
  
  private IBitAppBaseViewListener a(BitAppMsg.CreateViewListener paramCreateViewListener)
  {
    int j = this.mBitAppMsgItemLists.size();
    HashSet localHashSet = new HashSet(j);
    int i = 0;
    while (i < j)
    {
      localHashSet.add(String.valueOf(((BitAppMsgItemElement)this.mBitAppMsgItemLists.get(i)).a()));
      i += 1;
    }
    return new BitAppMsg.ViewListener(localHashSet, paramCreateViewListener);
  }
  
  public byte[] getBytes()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      localObjectOutputStream.writeUTF(getClass().getName());
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BitAppMsg", 2, "getBytes failure");
      }
    }
    return null;
  }
  
  public byte[] getDecodeXml()
  {
    if (this.mZipMark == 0) {
      return this.mXml;
    }
    if (this.mDecodeXml != null) {
      return this.mDecodeXml;
    }
    this.mDecodeXml = BitAppMsgUtils.a(this.mXml, this.mZipMark);
    return this.mDecodeXml;
  }
  
  public byte[] getEncodeXml()
  {
    return this.mXml;
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getModuleId()
  {
    int j = 0;
    int i = j;
    if (this.mBitAppMsgItemLists != null)
    {
      i = j;
      if (this.mBitAppMsgItemLists.size() > 0) {
        i = ((BitAppMsgItemElement)this.mBitAppMsgItemLists.get(0)).a();
      }
    }
    return i;
  }
  
  public long getMsgId()
  {
    return this.mMsgId;
  }
  
  public BitAppMsgNode getNode()
  {
    return this.mRootNode;
  }
  
  public String getSummery()
  {
    if (!TextUtils.isEmpty(this.mMsgBrief)) {
      return this.mMsgBrief;
    }
    return ContextUtils.INSTANCE.getApplicationContext().getString(2131361795);
  }
  
  public List getView(Context paramContext, Bundle paramBundle, BitAppMsg.CreateViewListener paramCreateViewListener)
  {
    int j = this.mBitAppMsgItemLists.size();
    ArrayList localArrayList = new ArrayList(j);
    if (j > 0)
    {
      paramCreateViewListener = a(paramCreateViewListener);
      int i = 0;
      if (i < j)
      {
        BitAppBaseView localBitAppBaseView = ((BitAppMsgItemElement)this.mBitAppMsgItemLists.get(i)).a(paramContext, paramBundle, paramCreateViewListener);
        if (localBitAppBaseView != null) {
          localArrayList.add(localBitAppBaseView);
        }
        for (;;)
        {
          i += 1;
          break;
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 4, "Create item view failure by #BitAppMsgItemElement");
          }
        }
      }
    }
    return localArrayList;
  }
  
  public boolean hasFlag(int paramInt)
  {
    return (this.mFlag & paramInt) == paramInt;
  }
  
  protected void parseAttrubutes(BitAppMsgNode paramBitAppMsgNode)
  {
    if (paramBitAppMsgNode == null) {
      return;
    }
    String str = paramBitAppMsgNode.a("flag");
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.mFlag = Integer.parseInt(str);
      this.mMsgBrief = paramBitAppMsgNode.a("brief");
      this.mCompatibleText = paramBitAppMsgNode.a("compatible_text");
      this.mRequiredVersionAndroid = paramBitAppMsgNode.a("android_v");
      this.mLolaThumbnail = paramBitAppMsgNode.a("lolaThumbnail");
      this.mLolaUrl = paramBitAppMsgNode.a("lolaUrl");
      try
      {
        this.mWidth = Integer.parseInt(paramBitAppMsgNode.a("width"));
        try
        {
          this.mHeight = Integer.parseInt(paramBitAppMsgNode.a("height"));
          try
          {
            this.mPaddingLeft = Integer.parseInt(paramBitAppMsgNode.a("left"));
            try
            {
              this.mPaddingTop = Integer.parseInt(paramBitAppMsgNode.a("top"));
              try
              {
                this.mPaddingRight = Integer.parseInt(paramBitAppMsgNode.a("right"));
                try
                {
                  this.mPaddingBottom = Integer.parseInt(paramBitAppMsgNode.a("bottom"));
                  try
                  {
                    this.mAbility = Long.parseLong(paramBitAppMsgNode.a("ability"));
                    str = paramBitAppMsgNode.a("adverSign");
                    try
                    {
                      if (!TextUtils.isEmpty(str)) {
                        this.adverSign = Integer.parseInt(str);
                      }
                      this.adverKey = paramBitAppMsgNode.a("adverKey");
                      this.mRootNode = paramBitAppMsgNode;
                      return;
                    }
                    catch (NumberFormatException localNumberFormatException1)
                    {
                      for (;;) {}
                    }
                  }
                  catch (Exception localException1)
                  {
                    for (;;) {}
                  }
                }
                catch (Exception localException2)
                {
                  for (;;) {}
                }
              }
              catch (Exception localException3)
              {
                for (;;) {}
              }
            }
            catch (Exception localException4)
            {
              for (;;) {}
            }
          }
          catch (Exception localException5)
          {
            for (;;) {}
          }
        }
        catch (Exception localException6)
        {
          for (;;) {}
        }
      }
      catch (Exception localException7)
      {
        for (;;) {}
      }
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      for (;;) {}
    }
  }
  
  protected boolean parseItem(BitAppMsgNode paramBitAppMsgNode)
  {
    if ((paramBitAppMsgNode == null) || (!"item".equals(paramBitAppMsgNode.b))) {
      return true;
    }
    int i3 = paramBitAppMsgNode.a();
    Object localObject2 = "";
    int k = 1;
    int m = 0;
    int j = 1;
    Object localObject1 = "";
    int i = 0;
    if (i < i3)
    {
      BitAppMsgNode localBitAppMsgNode = paramBitAppMsgNode.a(i);
      Object localObject7;
      int i2;
      int i1;
      int n;
      Object localObject3;
      if (localBitAppMsgNode == null)
      {
        localObject7 = localObject1;
        i2 = j;
        i1 = k;
        n = m;
        localObject3 = localObject2;
      }
      for (;;)
      {
        i += 1;
        localObject2 = localObject3;
        m = n;
        k = i1;
        j = i2;
        localObject1 = localObject7;
        break;
        if ((localBitAppMsgNode.jdField_a_of_type_Int == 3) && ("module_name".equals(localBitAppMsgNode.b)))
        {
          localObject3 = localBitAppMsgNode.jdField_a_of_type_JavaLangString;
          n = m;
          i1 = k;
          i2 = j;
          localObject7 = localObject1;
        }
        else
        {
          Object localObject4;
          if ((localBitAppMsgNode.jdField_a_of_type_Int == 3) && ("module_version".equals(localBitAppMsgNode.b)))
          {
            try
            {
              i1 = Integer.parseInt(localBitAppMsgNode.jdField_a_of_type_JavaLangString);
              localObject3 = localObject2;
              n = m;
              i2 = j;
              localObject7 = localObject1;
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              localNumberFormatException1.printStackTrace();
              localObject4 = localObject2;
              n = m;
              i1 = k;
              i2 = j;
              localObject7 = localObject1;
            }
          }
          else
          {
            Object localObject5;
            if ((localBitAppMsgNode.jdField_a_of_type_Int == 3) && ("module_id".equals(localBitAppMsgNode.b)))
            {
              try
              {
                n = Integer.parseInt(localBitAppMsgNode.jdField_a_of_type_JavaLangString);
                localObject4 = localObject2;
                i1 = k;
                i2 = j;
                localObject7 = localObject1;
              }
              catch (NumberFormatException localNumberFormatException2)
              {
                localNumberFormatException2.printStackTrace();
                localObject5 = localObject2;
                n = m;
                i1 = k;
                i2 = j;
                localObject7 = localObject1;
              }
            }
            else if ((localBitAppMsgNode.jdField_a_of_type_Int == 3) && ("data".equals(localBitAppMsgNode.b)))
            {
              localObject7 = localBitAppMsgNode.jdField_a_of_type_JavaLangString;
              localObject5 = localObject2;
              n = m;
              i1 = k;
              i2 = j;
            }
            else
            {
              Object localObject6;
              if ((localBitAppMsgNode.jdField_a_of_type_Int == 3) && ("module_state".equals(localBitAppMsgNode.b)))
              {
                try
                {
                  i2 = Integer.parseInt(localBitAppMsgNode.jdField_a_of_type_JavaLangString);
                  localObject5 = localObject2;
                  n = m;
                  i1 = k;
                  localObject7 = localObject1;
                }
                catch (NumberFormatException localNumberFormatException3)
                {
                  localNumberFormatException3.printStackTrace();
                  localObject6 = localObject2;
                  n = m;
                  i1 = k;
                  i2 = j;
                  localObject7 = localObject1;
                }
              }
              else
              {
                localObject6 = localObject2;
                n = m;
                i1 = k;
                i2 = j;
                localObject7 = localObject1;
                if (QLog.isColorLevel())
                {
                  QLog.d("BitAppMsg", 2, "parseItem unknow tag is " + localBitAppMsgNode.b + ", type is " + localBitAppMsgNode.jdField_a_of_type_Int + ", ignore it");
                  localObject6 = localObject2;
                  n = m;
                  i1 = k;
                  i2 = j;
                  localObject7 = localObject1;
                }
              }
            }
          }
        }
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return false;
    }
    paramBitAppMsgNode = new BitAppMsgItemElement((String)localObject2, m, k, j, (String)localObject1);
    this.mBitAppMsgItemLists.add(paramBitAppMsgNode);
    if (paramBitAppMsgNode.a()) {
      this.mDataException = true;
    }
    return true;
  }
  
  protected void parseNodes(BitAppMsgNode paramBitAppMsgNode)
  {
    int j = 0;
    if (paramBitAppMsgNode == null) {
      return;
    }
    int m = paramBitAppMsgNode.a();
    int i = 0;
    label16:
    BitAppMsgNode localBitAppMsgNode;
    int k;
    if (i < m)
    {
      localBitAppMsgNode = paramBitAppMsgNode.a(i);
      if (localBitAppMsgNode != null) {
        break label47;
      }
      k = j;
    }
    for (;;)
    {
      i += 1;
      j = k;
      break label16;
      break;
      label47:
      if (localBitAppMsgNode.b.equals("item"))
      {
        k = j;
        if (j == 0)
        {
          k = j;
          if (!parseItem(localBitAppMsgNode)) {
            k = 1;
          }
        }
      }
      else
      {
        k = j;
        if (QLog.isColorLevel())
        {
          QLog.d("BitAppMsg", 2, "parseMsgNodes unknow tag");
          k = j;
        }
      }
    }
  }
  
  protected void parseXml(byte[] paramArrayOfByte, int paramInt)
  {
    this.mXml = paramArrayOfByte;
    this.mZipMark = paramInt;
    paramArrayOfByte = BitAppMsgUtils.a(paramArrayOfByte, paramInt);
    if (paramArrayOfByte != null)
    {
      parseAttrubutes(paramArrayOfByte);
      parseNodes(paramArrayOfByte);
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    try
    {
      int i = paramObjectInput.readInt();
      this.mVersion = i;
      if (i == 1)
      {
        this.mXml = new byte[paramObjectInput.readInt()];
        paramObjectInput.readFully(this.mXml);
        this.mZipMark = paramObjectInput.readInt();
        this.mState = paramObjectInput.readInt();
        this.mThumbNailURl = paramObjectInput.readUTF();
        this.mAbility = paramObjectInput.readLong();
        this.mCompatibleText = paramObjectInput.readUTF();
        this.mDataException = paramObjectInput.readBoolean();
        parseXml(this.mXml, this.mZipMark);
        this.mHeight = paramObjectInput.readInt();
        this.mMsgId = paramObjectInput.readLong();
        return;
      }
      this.mMsgException = true;
      return;
    }
    catch (Exception paramObjectInput)
    {
      if ((paramObjectInput.getMessage() != null) && (paramObjectInput.getMessage().equals("bitappmsg_version_error"))) {
        this.mMsgException = true;
      }
    }
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  public void setMsgId(long paramLong)
  {
    this.mMsgId = paramLong;
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mXml.length);
    paramObjectOutput.write(this.mXml);
    paramObjectOutput.writeInt(this.mZipMark);
    paramObjectOutput.writeInt(this.mState);
    if (this.mThumbNailURl == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.mAbility);
      if (this.mCompatibleText != null) {
        break label134;
      }
    }
    label134:
    for (String str = "";; str = this.mCompatibleText)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeBoolean(this.mDataException);
      paramObjectOutput.writeInt(this.mHeight);
      paramObjectOutput.writeLong(this.mMsgId);
      return;
      str = this.mThumbNailURl;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */