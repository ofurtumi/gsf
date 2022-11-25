# vikublað 12 - gagnasafnsfræði

| | tími 3ja laga | tími 2ja laga |
|---|---|---|
| biðtími milli db og vinnslu | 0.5ms | 10.0ms |
| bandbreidd milli db og vinnslu | 20Gb/s | 10Mb/s |
| biðtími milli vinnslu og viðmóts | 10ms | 0 |
| bandbreidd milli vinnslu og viðmóts | 10Mb/s | $\infin$ |

## gerum ráð fyrir eftirfarandi  

1. 
> viðmót sendir 1000 bæti til vinnslunar. Þessi 1000 bæti skilgreina þá vinnslu sem vinna skal  

2. 
> vinnslan byrjar  samstundis  (þegar  öll  1000  bætin  eru  komin)  að  senda  runuskipana til gagnagrunnsins. Samtals eru það 1000 skipanir sem hver um sig eru 100 bæti.  Gagnagrunnurinn bregst samstundis við hverri skipun (þegar hún eröll komin til gagnagrunnsins) og sendir 10 bæti til baka til vinnslunnar,  semsendir næstu skipun um leið og svar hefur að fullu borist við fyrri skipun.

3. 
> Þegar vinnslan er búin að fá öll 1000 svör frá gagnagrunninum tekur það vinnsl-una 100 millisekúndur að reikna niðurstöðu sem er 1000 bæti.  

4. 
> Þegar niðurstaðan er tilbúin sendir vinnslan hana til viðmótsins.


## spurningar

### 1. 
almenn formúla til að reikna svartíma er $r = \frac{d}{b}+n*t+c$ 

endurskrifum formúluna þar sem hún notar núverandi kringumstæður sem eftirfarandi föll:  

$$
\begin{align}
\frac{1000_{bytes}}{b_g}+\frac{t_g}{2}+100_{ms}+\frac{110_{bytes}}{b_v}+\frac{t_v}{2}\\
\frac{110_{bytes}}{b_g}+(t_g*1000)+c\\
(\frac{110_{bytes}}{b_g}+(t_g*1000))+(\frac{2000_{ms}}{b_v}+t_v+100_{ms})\\
\end{align}
$$

### 2. 
