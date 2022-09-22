# gagnasafnsfræði - vika 4

## 1.
hér er verið að framkvæma natural outer join:
| R.X | R.Y | R.Z | S.W | S.T |
|:---:|:---:|:---:|:---:|:---:|
|15|c|8|10|6|
|15|c|8|10|5|

## 2.
hér er verið að framkvæma left outer join:
| R.X | R.Y | R.Z | S.W | S.T |
|:---:|:---:|:---:|:---:|:---:|
|10|b|5|null|null|
|15|c|8|10|6|
|15|c|8|10|5|
|25|b|6|null|null|

## 3. 
hér er verið að framkvæma right outer join:
| R.X | R.Z | S.W | S.Y | S.T |
|:---:|:---:|:---:|:---:|:---:|
|15|8|10|6|10|c|6|
|null|null|25|d|3|
|15|8|10|5|10|c|6|

## 4. 
hér er verið að framkvæma full outer join:
| R.X | R.Y | R.Z | S.W | S.Y | S.T |
|:---:|:---:|:---:|:---:|:---:|:---:|
|10|b|5|null|null|null|
|15|c|8|10|c|6|
|15|c|8|10|c|5|
|25|b|6|null|null|null|
|null|null|null|25|d|3|

## 5.
hér er verið að framkvæma outer join á Y og þar sem Z = W:
í fljótu bragði er hægt að sjá að Z er aldrei jafnt og w þannig þetta skilar fullum gildum beggja tafla nema hvað joinið "tekst" aldrei sjá töflu

| R.X | R.Y | R.Z | S.W | S.Y | S.T |
|:---:|:---:|:---:|:---:|:---:|:---:|
|10|b|5|null|null|null|
|15|c|8|null|null|null|
|25|b|6|null|null|null|
|null|null|null|10|c|6|
|null|null|null|25|d|3|
|null|null|null|10|c|5|