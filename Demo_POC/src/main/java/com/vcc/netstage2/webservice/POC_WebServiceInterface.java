package com.vcc.netstage2.webservice;

import com.vcc.netstage2.commons.InputDeclaration;
import com.vcc.netstage2.commons.OutputDeclaration;
import com.vcc.netstage2.commons.ExitNote.ExitNoteInput;
import com.vcc.netstage2.commons.ExitNote.OutputExitNote;

public interface POC_WebServiceInterface {
	
	public OutputDeclaration sendDeclaration(InputDeclaration input);
	
	public OutputExitNote sendExitNote(ExitNoteInput exitnoteInput);
	
}
