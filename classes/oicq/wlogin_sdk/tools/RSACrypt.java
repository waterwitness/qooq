package oicq.wlogin_sdk.tools;

import android.content.Context;

public class RSACrypt
{
  protected static final String DEFAULT_PRIV_KEY = "3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9";
  public static final String DEFAULT_PUB_KEY = "30818902818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d0203010001";
  private Context _context;
  private byte[] _priv_key = new byte[0];
  private byte[] _pub_key = new byte[0];
  
  public RSACrypt(Context paramContext)
  {
    this._context = paramContext;
    try
    {
      util.loadLibrary("wtecdh", this._context);
      return;
    }
    catch (UnsatisfiedLinkError paramContext) {}
  }
  
  private native byte[] decryptdata(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private native byte[] encryptdata(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private native int genrsakey();
  
  public byte[] DecryptData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    localObject = null;
    byte[] arrayOfByte1 = null;
    if (paramArrayOfByte2 == null) {
      localObject = arrayOfByte1;
    }
    for (;;)
    {
      return (byte[])localObject;
      arrayOfByte1 = paramArrayOfByte1;
      if (paramArrayOfByte1 == null)
      {
        paramArrayOfByte1 = util.get_rsa_privkey(this._context);
        if (paramArrayOfByte1 != null)
        {
          arrayOfByte1 = paramArrayOfByte1;
          if (paramArrayOfByte1.length != 0) {}
        }
        else
        {
          arrayOfByte1 = util.string_to_buf("3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9");
        }
      }
      try
      {
        byte[] arrayOfByte2 = decryptdata(arrayOfByte1, paramArrayOfByte2);
        if (arrayOfByte2 != null)
        {
          paramArrayOfByte1 = arrayOfByte2;
          localObject = arrayOfByte2;
          if (arrayOfByte2.length != 0) {}
        }
        else
        {
          localObject = arrayOfByte2;
          paramArrayOfByte1 = decryptdata(util.string_to_buf("3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9"), paramArrayOfByte2);
        }
      }
      catch (UnsatisfiedLinkError paramArrayOfByte1)
      {
        for (;;)
        {
          paramArrayOfByte1 = (byte[])localObject;
        }
      }
      localObject = paramArrayOfByte1;
      if (paramArrayOfByte1 != null) {
        continue;
      }
      try
      {
        arrayOfByte1 = util.RSADecrypt(paramArrayOfByte2, util.RSAPrivKeyFromJNI(arrayOfByte1));
        if (arrayOfByte1 != null)
        {
          localObject = arrayOfByte1;
          paramArrayOfByte1 = arrayOfByte1;
          if (arrayOfByte1.length != 0) {
            continue;
          }
        }
        paramArrayOfByte1 = arrayOfByte1;
        paramArrayOfByte2 = util.RSADecrypt(paramArrayOfByte2, util.RSAPrivKeyFromJNI(util.string_to_buf("3082025e02010002818100daaa2a418b271f3dfcf8f0a9120326d47f07618593d8d71d61a4fe987cc47740e491105bf8e68bd479bf51dfe19d3b06e12017df6d87a0f43bb82b57f59bd4220f2a3d8d68904a6ddb51197989e6e82512d8d8fa6c41b755a8ca962595d3e1e1be7ea01677249be4794cd7c6682d611c1bd81f0a16231fb83517515b94d13e5d02030100010281806bbfca4ebde92b45fa7018f6d6ff6294f77b859cb2fbf9146b5748758f95a845fbdb57ba5a6e109d44d8f7d9606d7ff6a5dc90a6f26c10ee08b779f43ffce78c6fc0feb8a063885e1b9ee6f3615b8b850e6b89365fe7037de6928e3ca2b93c55f60fff2873ce9a88254c4c553aece69c311ddd37bb6dfc8c45399144a59f25e9024100f12a24798dfc2d56e719df7a8f9f870037007ac187c1a76a88e4749347cbc270ea54491b27309d02d0d0e1bb566a3f4972c286193e34b3863962a103ab2e9063024100e81db1b9e333baa72636599b792f7ae2fc06593a94851bd15c5d209c5d5d2836ecf2309c52426ca297475bfd8920e5fade8765afd9f6822ee4b7e333d234523f024100e356ead37bb981b42e5f0180b3eb9a83e5559a62ddeafc3b3d98bf1c27ce3919e08c5bee30df6ee3bc9d6c6e01645f0c8a163dfb85dc806fc3a0ea505f0aa229024100dee10c73f2bf0c1e4de9e8370ab155ad38d49bbf4d375713bc3dcbff7902e7877e13bc2b8e2d2c051f7faccc116d5e877a3fc69b898e5348d5e3e0ad34cd7a9f024100ede9b6081428b058d2db5c7ccbef7a178d9003c547319d177a5d1d219e9727f18dbe41008198af9a01fb684b6c96c536c8fbb98532b908028c2d4dce7281aff9")));
        return paramArrayOfByte2;
      }
      catch (Exception paramArrayOfByte2)
      {
        return paramArrayOfByte1;
      }
    }
  }
  
  public byte[] EncryptData(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 != null) {
        break label24;
      }
      localObject2 = localObject3;
    }
    label24:
    do
    {
      return (byte[])localObject2;
      try
      {
        localObject2 = encryptdata(paramArrayOfByte1, paramArrayOfByte2);
        localObject1 = localObject2;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;) {}
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    return util.RSAEncrypt(paramArrayOfByte2, util.RSAPubKeyFromJNI(paramArrayOfByte1));
  }
  
  /* Error */
  public int GenRSAKey()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 7
    //   9: iconst_0
    //   10: istore 8
    //   12: iconst_0
    //   13: istore 6
    //   15: iconst_0
    //   16: istore 9
    //   18: aload_0
    //   19: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   22: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   25: astore_1
    //   26: aload_0
    //   27: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   30: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   33: astore_2
    //   34: aload_1
    //   35: ifnull +46 -> 81
    //   38: aload_1
    //   39: arraylength
    //   40: ifle +41 -> 81
    //   43: aload_2
    //   44: ifnull +37 -> 81
    //   47: aload_2
    //   48: arraylength
    //   49: ifle +32 -> 81
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   57: checkcast 78	[B
    //   60: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   63: aload_0
    //   64: aload_2
    //   65: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   68: checkcast 78	[B
    //   71: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   74: iload 9
    //   76: istore 5
    //   78: iload 5
    //   80: ireturn
    //   81: ldc 2
    //   83: monitorenter
    //   84: aload_0
    //   85: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   88: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   91: astore_1
    //   92: aload_0
    //   93: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   96: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   99: astore_2
    //   100: aload_1
    //   101: ifnull +133 -> 234
    //   104: aload_1
    //   105: arraylength
    //   106: ifle +128 -> 234
    //   109: aload_2
    //   110: ifnull +124 -> 234
    //   113: aload_2
    //   114: arraylength
    //   115: ifle +119 -> 234
    //   118: aload_0
    //   119: aload_1
    //   120: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   123: checkcast 78	[B
    //   126: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   129: aload_0
    //   130: aload_2
    //   131: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   134: checkcast 78	[B
    //   137: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   140: ldc 84
    //   142: ldc 86
    //   144: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: iconst_1
    //   148: istore 6
    //   150: ldc 2
    //   152: monitorexit
    //   153: iload 4
    //   155: istore 5
    //   157: iload 6
    //   159: ifne -81 -> 78
    //   162: ldc 2
    //   164: monitorenter
    //   165: aload_0
    //   166: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   169: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   172: astore_1
    //   173: aload_0
    //   174: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   177: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   180: astore_2
    //   181: aload_1
    //   182: ifnull +426 -> 608
    //   185: aload_1
    //   186: arraylength
    //   187: ifle +421 -> 608
    //   190: aload_2
    //   191: ifnull +417 -> 608
    //   194: aload_2
    //   195: arraylength
    //   196: ifle +412 -> 608
    //   199: aload_0
    //   200: aload_1
    //   201: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   204: checkcast 78	[B
    //   207: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   210: aload_0
    //   211: aload_2
    //   212: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   215: checkcast 78	[B
    //   218: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   221: ldc 92
    //   223: ldc 86
    //   225: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: ldc 2
    //   230: monitorexit
    //   231: iload 4
    //   233: ireturn
    //   234: ldc 94
    //   236: ldc 86
    //   238: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_0
    //   242: invokespecial 96	oicq/wlogin_sdk/tools/RSACrypt:genrsakey	()I
    //   245: istore 4
    //   247: iload 4
    //   249: istore 7
    //   251: new 98	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   258: ldc 101
    //   260: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: iload 4
    //   265: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: ldc 86
    //   273: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: iconst_0
    //   277: istore 6
    //   279: goto -129 -> 150
    //   282: iload 4
    //   284: istore 6
    //   286: iload 5
    //   288: istore 7
    //   290: ldc 2
    //   292: monitorexit
    //   293: aload_1
    //   294: athrow
    //   295: astore_1
    //   296: iload 4
    //   298: istore 6
    //   300: iload 5
    //   302: istore 4
    //   304: invokestatic 116	oicq/wlogin_sdk/tools/util:generateRSAKeyPair	()Ljava/security/KeyPair;
    //   307: astore_1
    //   308: aload_1
    //   309: ifnull +35 -> 344
    //   312: aload_0
    //   313: aload_1
    //   314: invokevirtual 122	java/security/KeyPair:getPublic	()Ljava/security/PublicKey;
    //   317: invokeinterface 128 1 0
    //   322: invokestatic 132	oicq/wlogin_sdk/tools/util:RSAPubKeyFromJava	([B)[B
    //   325: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   328: aload_0
    //   329: aload_1
    //   330: invokevirtual 136	java/security/KeyPair:getPrivate	()Ljava/security/PrivateKey;
    //   333: invokeinterface 139 1 0
    //   338: invokestatic 142	oicq/wlogin_sdk/tools/util:RSAPrivKeyFromJava	([B)[B
    //   341: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   344: iload 4
    //   346: istore 5
    //   348: iload 6
    //   350: ifne -272 -> 78
    //   353: ldc 2
    //   355: monitorenter
    //   356: aload_0
    //   357: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   360: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   363: astore_1
    //   364: aload_0
    //   365: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   368: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   371: astore_2
    //   372: aload_1
    //   373: ifnull +190 -> 563
    //   376: aload_1
    //   377: arraylength
    //   378: ifle +185 -> 563
    //   381: aload_2
    //   382: ifnull +181 -> 563
    //   385: aload_2
    //   386: arraylength
    //   387: ifle +176 -> 563
    //   390: aload_0
    //   391: aload_1
    //   392: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   395: checkcast 78	[B
    //   398: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   401: aload_0
    //   402: aload_2
    //   403: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   406: checkcast 78	[B
    //   409: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   412: ldc 92
    //   414: ldc 86
    //   416: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: ldc 2
    //   421: monitorexit
    //   422: goto -191 -> 231
    //   425: ldc 2
    //   427: monitorenter
    //   428: aload_0
    //   429: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   432: invokestatic 77	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   435: astore_2
    //   436: aload_0
    //   437: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   440: invokestatic 50	oicq/wlogin_sdk/tools/util:get_rsa_privkey	(Landroid/content/Context;)[B
    //   443: astore_3
    //   444: aload_2
    //   445: ifnull +73 -> 518
    //   448: aload_2
    //   449: arraylength
    //   450: ifle +68 -> 518
    //   453: aload_3
    //   454: ifnull +64 -> 518
    //   457: aload_3
    //   458: arraylength
    //   459: ifle +59 -> 518
    //   462: aload_0
    //   463: aload_2
    //   464: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   467: checkcast 78	[B
    //   470: putfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   473: aload_0
    //   474: aload_3
    //   475: invokevirtual 82	[B:clone	()Ljava/lang/Object;
    //   478: checkcast 78	[B
    //   481: putfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   484: ldc 92
    //   486: ldc 86
    //   488: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   491: ldc 2
    //   493: monitorexit
    //   494: aload_1
    //   495: athrow
    //   496: astore_1
    //   497: iconst_0
    //   498: istore 6
    //   500: iload 8
    //   502: istore 4
    //   504: iload 6
    //   506: ifeq -81 -> 425
    //   509: iload 4
    //   511: ireturn
    //   512: astore_1
    //   513: ldc 2
    //   515: monitorexit
    //   516: aload_1
    //   517: athrow
    //   518: ldc -112
    //   520: ldc 86
    //   522: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload_0
    //   526: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   529: aload_0
    //   530: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   533: invokestatic 148	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   536: aload_0
    //   537: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   540: aload_0
    //   541: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   544: invokestatic 151	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   547: ldc -103
    //   549: ldc 86
    //   551: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   554: goto -63 -> 491
    //   557: astore_1
    //   558: ldc 2
    //   560: monitorexit
    //   561: aload_1
    //   562: athrow
    //   563: ldc -112
    //   565: ldc 86
    //   567: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: aload_0
    //   571: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   574: aload_0
    //   575: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   578: invokestatic 148	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   581: aload_0
    //   582: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   585: aload_0
    //   586: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   589: invokestatic 151	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   592: ldc -103
    //   594: ldc 86
    //   596: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   599: goto -180 -> 419
    //   602: astore_1
    //   603: ldc 2
    //   605: monitorexit
    //   606: aload_1
    //   607: athrow
    //   608: ldc -112
    //   610: ldc 86
    //   612: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   615: aload_0
    //   616: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   619: aload_0
    //   620: getfield 25	oicq/wlogin_sdk/tools/RSACrypt:_pub_key	[B
    //   623: invokestatic 148	oicq/wlogin_sdk/tools/util:save_rsa_pubkey	(Landroid/content/Context;[B)V
    //   626: aload_0
    //   627: getfield 29	oicq/wlogin_sdk/tools/RSACrypt:_context	Landroid/content/Context;
    //   630: aload_0
    //   631: getfield 27	oicq/wlogin_sdk/tools/RSACrypt:_priv_key	[B
    //   634: invokestatic 151	oicq/wlogin_sdk/tools/util:save_rsa_privkey	(Landroid/content/Context;[B)V
    //   637: ldc -103
    //   639: ldc 86
    //   641: invokestatic 90	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: goto -416 -> 228
    //   647: astore_1
    //   648: iload 4
    //   650: istore 6
    //   652: iload 5
    //   654: istore 4
    //   656: goto -152 -> 504
    //   659: astore_1
    //   660: goto -156 -> 504
    //   663: astore_1
    //   664: iconst_0
    //   665: istore 6
    //   667: iload 7
    //   669: istore 4
    //   671: goto -367 -> 304
    //   674: astore_1
    //   675: iload 6
    //   677: istore 4
    //   679: iload 7
    //   681: istore 5
    //   683: goto -401 -> 282
    //   686: astore_1
    //   687: iload 4
    //   689: istore 5
    //   691: iload 6
    //   693: istore 4
    //   695: goto -413 -> 282
    //   698: astore_1
    //   699: iconst_0
    //   700: istore 6
    //   702: iload 5
    //   704: istore 4
    //   706: iload 6
    //   708: istore 5
    //   710: goto -428 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	713	0	this	RSACrypt
    //   25	269	1	arrayOfByte1	byte[]
    //   295	1	1	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   307	188	1	localObject1	Object
    //   496	1	1	localObject2	Object
    //   512	5	1	localObject3	Object
    //   557	5	1	localObject4	Object
    //   602	5	1	localObject5	Object
    //   647	1	1	localObject6	Object
    //   659	1	1	localObject7	Object
    //   663	1	1	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   674	1	1	localObject8	Object
    //   686	1	1	localObject9	Object
    //   698	1	1	localObject10	Object
    //   33	431	2	arrayOfByte2	byte[]
    //   443	32	3	arrayOfByte3	byte[]
    //   1	704	4	i	int
    //   4	705	5	j	int
    //   13	694	6	k	int
    //   7	673	7	m	int
    //   10	491	8	n	int
    //   16	59	9	i1	int
    // Exception table:
    //   from	to	target	type
    //   293	295	295	java/lang/UnsatisfiedLinkError
    //   81	84	496	finally
    //   428	444	512	finally
    //   448	453	512	finally
    //   457	491	512	finally
    //   491	494	512	finally
    //   513	516	512	finally
    //   518	554	512	finally
    //   356	372	557	finally
    //   376	381	557	finally
    //   385	419	557	finally
    //   419	422	557	finally
    //   558	561	557	finally
    //   563	599	557	finally
    //   165	181	602	finally
    //   185	190	602	finally
    //   194	228	602	finally
    //   228	231	602	finally
    //   603	606	602	finally
    //   608	644	602	finally
    //   293	295	647	finally
    //   304	308	659	finally
    //   312	344	659	finally
    //   81	84	663	java/lang/UnsatisfiedLinkError
    //   251	276	674	finally
    //   290	293	674	finally
    //   150	153	686	finally
    //   84	100	698	finally
    //   104	109	698	finally
    //   113	147	698	finally
    //   234	247	698	finally
  }
  
  public byte[] get_priv_key()
  {
    return this._priv_key;
  }
  
  public byte[] get_pub_key()
  {
    return this._pub_key;
  }
  
  public void set_priv_key(byte[] paramArrayOfByte)
  {
    this._priv_key = paramArrayOfByte;
  }
  
  public void set_pub_key(byte[] paramArrayOfByte)
  {
    this._pub_key = paramArrayOfByte;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oicq\wlogin_sdk\tools\RSACrypt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */