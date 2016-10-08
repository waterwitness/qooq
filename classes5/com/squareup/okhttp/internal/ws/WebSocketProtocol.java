package com.squareup.okhttp.internal.ws;

public final class WebSocketProtocol
{
  public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
  static final int B0_FLAG_FIN = Integer.parseInt("10000000", 2);
  static final int B0_FLAG_RSV1 = Integer.parseInt("01000000", 2);
  static final int B0_FLAG_RSV2 = Integer.parseInt("00100000", 2);
  static final int B0_FLAG_RSV3 = Integer.parseInt("00010000", 2);
  static final int B0_MASK_OPCODE = Integer.parseInt("00001111", 2);
  static final int B1_FLAG_MASK = Integer.parseInt("10000000", 2);
  static final int B1_MASK_LENGTH = Integer.parseInt("01111111", 2);
  static final int OPCODE_BINARY = 2;
  static final int OPCODE_CONTINUATION = 0;
  static final int OPCODE_CONTROL_CLOSE = 8;
  static final int OPCODE_CONTROL_PING = 9;
  static final int OPCODE_CONTROL_PONG = 10;
  static final int OPCODE_FLAG_CONTROL = Integer.parseInt("00001000", 2);
  static final int OPCODE_TEXT = 1;
  static final int PAYLOAD_LONG = 127;
  static final int PAYLOAD_MAX = 125;
  static final int PAYLOAD_SHORT = 126;
  
  private WebSocketProtocol()
  {
    throw new AssertionError("No instances.");
  }
  
  static void toggleMask(byte[] paramArrayOfByte1, long paramLong1, byte[] paramArrayOfByte2, long paramLong2)
  {
    int j = paramArrayOfByte2.length;
    int i = 0;
    for (;;)
    {
      if (i >= paramLong1) {
        return;
      }
      int k = (int)(paramLong2 % j);
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[k]));
      i += 1;
      paramLong2 += 1L;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\squareup\okhttp\internal\ws\WebSocketProtocol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */