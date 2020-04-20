private void VolgaCTF()
{
    string input;
    long totalCounter;
    long hiedpuxyvs;
    long CLAO4r;
    input = Range(Strings.Chr(76) + Strings.Chr(0x31) + Strings.Chr(Conversion.Int("53"))); // Range("L15")
    for (outer = 1; outer <= Strings.Len(input); outer++)
    {
        totalCounter = 0;
        for (inner = 1; inner <= Strings.Len(input); inner++)
        {
            hiedpuxyvs = System.Convert.ToInt64(Cells(99 + outer, 99 + inner).Value);
            currentChar = Strings.Mid(input, inner, 1);
            totalCounter = totalCounter + hiedpuxyvs * Asc(currentChar);
        }

        CLAO4r = System.Convert.ToInt64(Cells(99 + outer, 99 + Strings.Len(input) + 1).Value);
        if ((CLAO4r != totalCounter))
        {
			//incorrect
            MsgBox(mWfDCE1CY0a(Strings.Chr(350416 / (double)2896) + Strings.Chr(Conversion.Int("114")) + Strings.Chr(Conversion.Int("&H72")) + Strings.Chr(Conversion.Int("57")) + Strings.Chr(0x56) + Strings.Chr(0x75) + "q" + Strings.Chr(Conversion.Int("113")) + Strings.Chr(4751 - 4652) + Strings.Chr(Conversion.Int("69")) + Strings.Chr(0x54) + Strings.Chr(0x67) + Strings.Chr(Conversion.Int("&H59")) + Strings.Chr(102) + "V" + Strings.Chr(Conversion.Int("86"))));
            return;
        }
    }

	//correct
    MsgBox(mWfDCE1CY0a(Strings.Chr(Conversion.Int("109")) + "q" + Strings.Chr(Conversion.Int("49")) + Strings.Chr(Conversion.Int("57")) + Strings.Chr(0x56) + Strings.Chr(0x65) + Strings.Chr(76) + Strings.Chr(Conversion.Int("112")) + Strings.Chr(Conversion.Int("86")) + "F" + Strings.Chr(Conversion.Int("114")) + Strings.Chr(-343 + 395) + Strings.Chr(0x32) + Strings.Chr(72) + Strings.Chr(Conversion.Int("&H31")) + Strings.Chr(100)));
}
