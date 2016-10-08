package com.facebook.stetho.dumpapp;

import com.facebook.stetho.common.LogUtil;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

class Framer
{
  public static final byte ENTER_FRAME_PREFIX = 33;
  public static final byte EXIT_FRAME_PREFIX = 120;
  public static final byte STDERR_FRAME_PREFIX = 50;
  public static final byte STDIN_FRAME_PREFIX = 45;
  public static final byte STDIN_REQUEST_FRAME_PREFIX = 95;
  public static final byte STDOUT_FRAME_PREFIX = 49;
  private static final String TAG = "FramingSocket";
  private final DataInputStream mInput;
  private final DataOutputStream mMultiplexedOutputStream;
  private final PrintStream mStderr;
  private final InputStream mStdin;
  private final PrintStream mStdout;
  
  public Framer(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    this.mInput = new DataInputStream(paramInputStream);
    this.mMultiplexedOutputStream = new DataOutputStream(paramOutputStream);
    this.mStdin = new FramingInputStream(null);
    this.mStdout = new PrintStream(new BufferedOutputStream(new FramingOutputStream((byte)49)));
    this.mStderr = new PrintStream(new FramingOutputStream((byte)50));
  }
  
  private static <T extends Throwable> T handleSuppression(@Nullable T paramT1, T paramT2)
  {
    if (paramT1 == null) {
      return paramT2;
    }
    LogUtil.i("FramingSocket", new Object[] { paramT2, "Suppressed while handling " + paramT1 });
    return paramT1;
  }
  
  public PrintStream getStderr()
  {
    return this.mStderr;
  }
  
  public InputStream getStdin()
  {
    return this.mStdin;
  }
  
  public PrintStream getStdout()
  {
    return this.mStdout;
  }
  
  public byte readFrameType()
    throws IOException
  {
    return this.mInput.readByte();
  }
  
  public int readInt()
    throws IOException
  {
    return this.mInput.readInt();
  }
  
  public String readString()
    throws IOException
  {
    byte[] arrayOfByte = new byte[this.mInput.readUnsignedShort()];
    this.mInput.readFully(arrayOfByte);
    return new String(arrayOfByte, Charset.forName("UTF-8"));
  }
  
  public void writeBlob(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.mMultiplexedOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeExitCode(int paramInt)
    throws IOException
  {
    this.mStdout.flush();
    this.mStderr.flush();
    writeIntFrame((byte)120, paramInt);
  }
  
  public void writeIntFrame(byte paramByte, int paramInt)
    throws IOException
  {
    this.mMultiplexedOutputStream.write(paramByte);
    this.mMultiplexedOutputStream.writeInt(paramInt);
  }
  
  private static class ClosedHelper
  {
    private volatile boolean mClosed;
    
    public void close()
    {
      this.mClosed = true;
    }
    
    public void throwIfClosed()
      throws IOException
    {
      if (this.mClosed) {
        throw new IOException("Stream is closed");
      }
    }
  }
  
  private class FramingInputStream
    extends InputStream
  {
    private final Framer.ClosedHelper mClosedHelper = new Framer.ClosedHelper(null);
    
    private FramingInputStream() {}
    
    public void close()
      throws IOException
    {
      this.mClosedHelper.close();
    }
    
    public int read()
      throws IOException
    {
      byte[] arrayOfByte = new byte[1];
      if (read(arrayOfByte) == 0) {
        return -1;
      }
      return arrayOfByte[0];
    }
    
    public int read(byte[] paramArrayOfByte)
      throws IOException
    {
      return read(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this.mClosedHelper.throwIfClosed();
      synchronized (Framer.this)
      {
        Framer.this.writeIntFrame((byte)95, paramInt2);
        byte b = Framer.this.readFrameType();
        if (b != 45) {
          throw new UnexpectedFrameException((byte)45, b);
        }
      }
      int i = Framer.this.readInt();
      if (i > 0)
      {
        if (i > paramInt2) {
          throw new DumpappFramingException("Expected at most " + paramInt2 + " bytes, got: " + i);
        }
        Framer.this.mInput.readFully(paramArrayOfByte, paramInt1, i);
      }
      return i;
    }
    
    /* Error */
    public long skip(long paramLong)
      throws IOException
    {
      // Byte code:
      //   0: lconst_0
      //   1: lstore 6
      //   3: lload_1
      //   4: ldc2_w 98
      //   7: invokestatic 105	java/lang/Math:min	(JJ)J
      //   10: l2i
      //   11: newarray <illegal type>
      //   13: astore 4
      //   15: aload_0
      //   16: getfield 15	com/facebook/stetho/dumpapp/Framer$FramingInputStream:this$0	Lcom/facebook/stetho/dumpapp/Framer;
      //   19: astore_3
      //   20: aload_3
      //   21: monitorenter
      //   22: lload 6
      //   24: lload_1
      //   25: lcmp
      //   26: iflt +8 -> 34
      //   29: aload_3
      //   30: monitorexit
      //   31: lload 6
      //   33: lreturn
      //   34: aload_0
      //   35: aload 4
      //   37: invokevirtual 40	com/facebook/stetho/dumpapp/Framer$FramingInputStream:read	([B)I
      //   40: istore 5
      //   42: iload 5
      //   44: iflt -15 -> 29
      //   47: lload 6
      //   49: iload 5
      //   51: i2l
      //   52: ladd
      //   53: lstore 6
      //   55: goto -33 -> 22
      //   58: astore 4
      //   60: aload_3
      //   61: monitorexit
      //   62: aload 4
      //   64: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	65	0	this	FramingInputStream
      //   0	65	1	paramLong	long
      //   19	42	3	localFramer	Framer
      //   13	23	4	arrayOfByte	byte[]
      //   58	5	4	localObject	Object
      //   40	10	5	i	int
      //   1	53	6	l	long
      // Exception table:
      //   from	to	target	type
      //   29	31	58	finally
      //   34	42	58	finally
      //   60	62	58	finally
    }
  }
  
  private class FramingOutputStream
    extends OutputStream
  {
    private final Framer.ClosedHelper mClosedHelper = new Framer.ClosedHelper(null);
    private final byte mPrefix;
    
    public FramingOutputStream(byte paramByte)
    {
      this.mPrefix = paramByte;
    }
    
    public void close()
      throws IOException
    {
      this.mClosedHelper.close();
    }
    
    public void write(int paramInt)
      throws IOException
    {
      byte[] arrayOfByte = new byte[1];
      arrayOfByte[0] = ((byte)paramInt);
      write(arrayOfByte, 0, arrayOfByte.length);
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      write(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this.mClosedHelper.throwIfClosed();
      if (paramInt2 > 0) {
        try
        {
          synchronized (Framer.this)
          {
            Framer.this.writeIntFrame(this.mPrefix, paramInt2);
            Framer.this.writeBlob(paramArrayOfByte, paramInt1, paramInt2);
            Framer.this.mMultiplexedOutputStream.flush();
            return;
          }
          return;
        }
        catch (IOException paramArrayOfByte)
        {
          throw new DumpappOutputBrokenException(paramArrayOfByte);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\dumpapp\Framer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */