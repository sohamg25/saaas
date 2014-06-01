clean : 
	rm *.bbl *.aux *.pdf *.ps *.dvi *.log *.blg

default :
	latex report_article.tex
	bibtex report_article
	latex report_article.tex
	latex report_article.tex
	dvips -f report_article.dvi > report_article.ps
	ps2pdf report_article.ps report_article.pdf
