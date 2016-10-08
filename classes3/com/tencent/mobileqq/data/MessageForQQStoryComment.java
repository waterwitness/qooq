package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MessageForQQStoryComment
  extends ChatMessage
{
  public static final String TAG = MessageForQQStoryComment.class.getSimpleName();
  public long author;
  public String comment;
  public String coverUrl;
  public long createTime;
  public int displayType;
  public String summary;
  public String title;
  public String vid;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void readExternal(ObjectInput paramObjectInput)
  {
    this.vid = paramObjectInput.readUTF();
    this.comment = paramObjectInput.readUTF();
    this.title = paramObjectInput.readUTF();
    this.coverUrl = paramObjectInput.readUTF();
    this.summary = paramObjectInput.readUTF();
    this.createTime = paramObjectInput.readLong();
    this.author = paramObjectInput.readLong();
  }
  
  private void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.vid);
    paramObjectOutput.writeUTF(this.comment);
    paramObjectOutput.writeUTF(this.title);
    paramObjectOutput.writeUTF(this.coverUrl);
    paramObjectOutput.writeUTF(this.summary);
    paramObjectOutput.writeLong(this.createTime);
    paramObjectOutput.writeLong(this.author);
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: new 78	java/io/ObjectInputStream
    //   3: dup
    //   4: new 80	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 84	com/tencent/mobileqq/data/MessageForQQStoryComment:msgData	[B
    //   12: invokespecial 87	java/io/ByteArrayInputStream:<init>	([B)V
    //   15: invokespecial 90	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 92	com/tencent/mobileqq/data/MessageForQQStoryComment:readExternal	(Ljava/io/ObjectInput;)V
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: aload_0
    //   30: getfield 47	com/tencent/mobileqq/data/MessageForQQStoryComment:comment	Ljava/lang/String;
    //   33: putfield 95	com/tencent/mobileqq/data/MessageForQQStoryComment:msg	Ljava/lang/String;
    //   36: aload_2
    //   37: ifnull +7 -> 44
    //   40: aload_2
    //   41: invokevirtual 98	java/io/ObjectInputStream:close	()V
    //   44: return
    //   45: astore_1
    //   46: aload_1
    //   47: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   50: return
    //   51: astore_3
    //   52: aconst_null
    //   53: astore_2
    //   54: aload_2
    //   55: astore_1
    //   56: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +14 -> 73
    //   62: aload_2
    //   63: astore_1
    //   64: ldc 109
    //   66: iconst_2
    //   67: ldc 111
    //   69: aload_3
    //   70: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   73: aload_2
    //   74: ifnull -30 -> 44
    //   77: aload_2
    //   78: invokevirtual 98	java/io/ObjectInputStream:close	()V
    //   81: return
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   87: return
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: ifnull +7 -> 99
    //   95: aload_1
    //   96: invokevirtual 98	java/io/ObjectInputStream:close	()V
    //   99: aload_2
    //   100: athrow
    //   101: astore_1
    //   102: aload_1
    //   103: invokevirtual 101	java/lang/Exception:printStackTrace	()V
    //   106: goto -7 -> 99
    //   109: astore_2
    //   110: goto -19 -> 91
    //   113: astore_3
    //   114: goto -60 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	MessageForQQStoryComment
    //   20	8	1	localObjectInputStream1	java.io.ObjectInputStream
    //   45	2	1	localException1	Exception
    //   55	9	1	localObjectInputStream2	java.io.ObjectInputStream
    //   82	2	1	localException2	Exception
    //   90	6	1	localObject1	Object
    //   101	2	1	localException3	Exception
    //   18	60	2	localObjectInputStream3	java.io.ObjectInputStream
    //   88	12	2	localObject2	Object
    //   109	1	2	localObject3	Object
    //   51	19	3	localException4	Exception
    //   113	1	3	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   40	44	45	java/lang/Exception
    //   0	19	51	java/lang/Exception
    //   77	81	82	java/lang/Exception
    //   0	19	88	finally
    //   95	99	101	java/lang/Exception
    //   21	26	109	finally
    //   28	36	109	finally
    //   56	62	109	finally
    //   64	73	109	finally
    //   21	26	113	java/lang/Exception
    //   28	36	113	java/lang/Exception
  }
  
  public String getNickName(QQAppInterface paramQQAppInterface)
  {
    String str1 = null;
    String str2 = this.title;
    if (isSend())
    {
      if (str2.matches("\\d+")) {
        str1 = ContactUtils.k(paramQQAppInterface, str2);
      }
      paramQQAppInterface = str1;
      if (TextUtils.isEmpty(str1)) {
        paramQQAppInterface = str2;
      }
    }
    do
    {
      return paramQQAppInterface;
      str1 = paramQQAppInterface.b();
      paramQQAppInterface = str1;
    } while (!TextUtils.isEmpty(str1));
    return "我";
  }
  
  protected void postRead()
  {
    super.parse();
  }
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: new 154	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 155	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 157	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 160	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial 162	com/tencent/mobileqq/data/MessageForQQStoryComment:writeExternal	(Ljava/io/ObjectOutput;)V
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 163	java/io/ObjectOutputStream:close	()V
    //   32: aload_2
    //   33: astore_1
    //   34: aload_0
    //   35: aload 4
    //   37: invokevirtual 167	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   40: putfield 84	com/tencent/mobileqq/data/MessageForQQStoryComment:msgData	[B
    //   43: aload_2
    //   44: ifnull +7 -> 51
    //   47: aload_2
    //   48: invokevirtual 163	java/io/ObjectOutputStream:close	()V
    //   51: aload 4
    //   53: ifnull +8 -> 61
    //   56: aload 4
    //   58: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   61: return
    //   62: astore_1
    //   63: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq -15 -> 51
    //   69: ldc 109
    //   71: iconst_2
    //   72: ldc -86
    //   74: aload_1
    //   75: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   78: goto -27 -> 51
    //   81: astore_1
    //   82: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq -24 -> 61
    //   88: ldc 109
    //   90: iconst_2
    //   91: ldc -86
    //   93: aload_1
    //   94: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   97: return
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_2
    //   101: aload_2
    //   102: astore_1
    //   103: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +14 -> 120
    //   109: aload_2
    //   110: astore_1
    //   111: ldc 109
    //   113: iconst_2
    //   114: ldc -86
    //   116: aload_3
    //   117: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload_2
    //   121: ifnull +7 -> 128
    //   124: aload_2
    //   125: invokevirtual 163	java/io/ObjectOutputStream:close	()V
    //   128: aload 4
    //   130: ifnull -69 -> 61
    //   133: aload 4
    //   135: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   138: return
    //   139: astore_1
    //   140: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq -82 -> 61
    //   146: ldc 109
    //   148: iconst_2
    //   149: ldc -86
    //   151: aload_1
    //   152: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   155: return
    //   156: astore_1
    //   157: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq -32 -> 128
    //   163: ldc 109
    //   165: iconst_2
    //   166: ldc -86
    //   168: aload_1
    //   169: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: goto -44 -> 128
    //   175: astore_2
    //   176: aconst_null
    //   177: astore_1
    //   178: aload_1
    //   179: ifnull +7 -> 186
    //   182: aload_1
    //   183: invokevirtual 163	java/io/ObjectOutputStream:close	()V
    //   186: aload 4
    //   188: ifnull +8 -> 196
    //   191: aload 4
    //   193: invokevirtual 168	java/io/ByteArrayOutputStream:close	()V
    //   196: aload_2
    //   197: athrow
    //   198: astore_1
    //   199: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq -16 -> 186
    //   205: ldc 109
    //   207: iconst_2
    //   208: ldc -86
    //   210: aload_1
    //   211: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   214: goto -28 -> 186
    //   217: astore_1
    //   218: invokestatic 107	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq -25 -> 196
    //   224: ldc 109
    //   226: iconst_2
    //   227: ldc -86
    //   229: aload_1
    //   230: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   233: goto -37 -> 196
    //   236: astore_2
    //   237: goto -59 -> 178
    //   240: astore_3
    //   241: goto -140 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	MessageForQQStoryComment
    //   20	14	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   62	13	1	localException1	Exception
    //   81	13	1	localException2	Exception
    //   102	9	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   139	13	1	localException3	Exception
    //   156	13	1	localException4	Exception
    //   177	6	1	localObject1	Object
    //   198	13	1	localException5	Exception
    //   217	13	1	localException6	Exception
    //   18	107	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   175	22	2	localObject2	Object
    //   236	1	2	localObject3	Object
    //   98	19	3	localException7	Exception
    //   240	1	3	localException8	Exception
    //   7	185	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   47	51	62	java/lang/Exception
    //   56	61	81	java/lang/Exception
    //   9	19	98	java/lang/Exception
    //   133	138	139	java/lang/Exception
    //   124	128	156	java/lang/Exception
    //   9	19	175	finally
    //   182	186	198	java/lang/Exception
    //   191	196	217	java/lang/Exception
    //   21	26	236	finally
    //   28	32	236	finally
    //   34	43	236	finally
    //   103	109	236	finally
    //   111	120	236	finally
    //   21	26	240	java/lang/Exception
    //   28	32	240	java/lang/Exception
    //   34	43	240	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\MessageForQQStoryComment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */