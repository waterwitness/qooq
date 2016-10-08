package com.facebook.stetho.dumpapp;

import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.server.SocketLike;
import com.facebook.stetho.server.SocketLikeHandler;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class DumpappSocketLikeHandler
  implements SocketLikeHandler
{
  public static final byte[] PROTOCOL_MAGIC = { 68, 85, 77, 80 };
  public static final int PROTOCOL_VERSION = 1;
  private final Dumper mDumper;
  
  public DumpappSocketLikeHandler(Dumper paramDumper)
  {
    this.mDumper = paramDumper;
  }
  
  static void dump(Dumper paramDumper, Framer paramFramer, String[] paramArrayOfString)
    throws IOException
  {
    try
    {
      paramFramer.writeExitCode(paramDumper.dump(paramFramer.getStdin(), paramFramer.getStdout(), paramFramer.getStderr(), paramArrayOfString));
      return;
    }
    catch (DumpappOutputBrokenException paramDumper) {}
  }
  
  private void establishConversation(DataInputStream paramDataInputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[4];
    paramDataInputStream.readFully(arrayOfByte);
    if (!Arrays.equals(PROTOCOL_MAGIC, arrayOfByte)) {
      throw logAndThrowProtocolException("Incompatible protocol, are you using an old dumpapp script?");
    }
    int i = paramDataInputStream.readInt();
    if (i != 1) {
      throw logAndThrowProtocolException("Expected version=1; got=" + i);
    }
  }
  
  private static IOException logAndThrowProtocolException(String paramString)
    throws IOException
  {
    LogUtil.w(paramString);
    throw new IOException(paramString);
  }
  
  private String[] readArgs(Framer paramFramer)
    throws IOException
  {
    for (;;)
    {
      try
      {
        i = paramFramer.readFrameType();
        switch (i)
        {
        case 33: 
          throw new DumpappFramingException("Expected enter frame, got: " + i);
        }
      }
      finally {}
      int j = paramFramer.readInt();
      String[] arrayOfString = new String[j];
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          return arrayOfString;
        }
        arrayOfString[i] = paramFramer.readString();
        i += 1;
      }
    }
  }
  
  public void onAccepted(SocketLike paramSocketLike)
    throws IOException
  {
    Object localObject = new DataInputStream(paramSocketLike.getInput());
    establishConversation((DataInputStream)localObject);
    paramSocketLike = new Framer((InputStream)localObject, paramSocketLike.getOutput());
    localObject = readArgs(paramSocketLike);
    dump(this.mDumper, paramSocketLike, (String[])localObject);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\dumpapp\DumpappSocketLikeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */