/**
 * This class file was automatically generated by jASN1 v1.5.0 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.modules.generated.x690.ber_example_3;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;

import org.openmuc.jasn1.compiler.modules.generated.x690.ber_example.*;
import org.openmuc.jasn1.compiler.modules.generated.x690.ber_example_2.*;

public class ChildInformationzz {

	public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 17);
	protected BerIdentifier id;

	public byte[] code = null;
	public Namezz name = null;

	public Datezz dateOfBirth = null;

	public ChildInformationzz() {
		id = identifier;
	}

	public ChildInformationzz(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public ChildInformationzz(Namezz name, Datezz dateOfBirth) {
		id = identifier;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {

		int codeLength;

		if (code != null) {
			codeLength = code.length;
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
		}
		else {
			codeLength = 0;
			codeLength += dateOfBirth.encode(os, false);
			// write tag {CONTEXT_CLASS, PRIMITIVE, 0}
			os.write(0x80);
			codeLength += 1;
			
			codeLength += name.encode(os, true);
			
			codeLength += BerLength.encodeLength(os, codeLength);
		}

		if (explicit) {
			codeLength += id.encode(os);
		}

		return codeLength;

	}

	public int decode(InputStream is, boolean explicit) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerIdentifier berIdentifier = new BerIdentifier();

		if (explicit) {
			codeLength += id.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		while (subCodeLength < length.val) {
			subCodeLength += berIdentifier.decode(is);
			if (berIdentifier.equals(Namezz.identifier)) {
				name = new Namezz();
				subCodeLength += name.decode(is, false);
			}
			else if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
				dateOfBirth = new Datezz();
				subCodeLength += dateOfBirth.decode(is, false);
			}
		}
		if (subCodeLength != length.val) {
			throw new IOException("Length of set does not match length tag, length tag: " + length.val + ", actual set length: " + subCodeLength);

		}
		codeLength += subCodeLength;

		return codeLength;
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE{");
		sb.append("name: ").append(name);
		
		sb.append(", ");
		sb.append("dateOfBirth: ").append(dateOfBirth);
		
		sb.append("}");
		return sb.toString();
	}

}

