clean : 
	rm *.bbl *.aux *.pdf *.ps *.dvi *.log *.blg

default :
	latex report_ieee.tex
	bibtex report_ieee
	latex report_ieee.tex
	latex report_ieee.tex
	dvips -f report_ieee.dvi > report_ieee.ps
	ps2pdf report_ieee.ps report_ieee.pdf
