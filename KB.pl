/*
pedestriancrossingahead
bushalt
childrencrossingahead
lightsignalisahead
pedestriansgolightsignl
pedestriansstoplight
stopsign
*/

obstacle(none,none,no).

obstacle(barricade,right,br).
obstacle(barricade,left,bl).
obstacle(barricade,middle,bf).

obstacle(vehicle,right,vr).
obstacle(vehicle,left,vl).
obstacle(vehicle,middle,vf).

obstacle(bicycle,right,byr).
obstacle(bicycle,left,byl).
obstacle(bicycle,middle,byf).

obstacle(dog,right,dr).
obstacle(dog,left,dl).
obstacle(dog,middle,df).

obstacle(pedestrian,right,per).
obstacle(pedestrian,left,pel).
obstacle(pedestrian,middle,pef).

obstacle(pothole,right,por).
obstacle(pothole,left,pol).
obstacle(pothole,middle,pof).



roadsign(none,no).
roadsign(pedestriancrossingahead,pc).
roadsign(bushalt,bh).
roadsign(childrencrossingahead,cc).
roadsign(lightsignalisahead,ls).
roadsign(pedestriansgolightsignl,pg).
roadsign(pedestriansstoplight,ps).
roadsign(stopsign,st).


solution(no,no,1).

solution(br,no,2).
solution(bl,no,3).
solution(bf,no,4).

solution(vr,no,5).
solution(vl,no,6).
solution(vf,no,7).

solution(byr,no,8).
solution(byl,no,9).
solution(byf,no,10).

solution(dr,no,11).
solution(dl,no,12).
solution(df,no,13).

solution(per,no,14).
solution(pel,no,15).
solution(pef,no,16).

solution(por,no,17).
solution(pol,no,18).
solution(pof,no,19).


solution(no,pc,40).
solution(no,bh,41).
solution(no,cc,42).
solution(no,ls,43).
solution(no,pg,44).
solution(no,ps,45).
solution(no,st,46).


solution(br,pc,47).
solution(br,bh,48).
solution(br,cc,49).
solution(br,ls,50).
solution(br,pg,51).
solution(br,ps,52).
solution(br,st,53).

solution(bl,pc,54).
solution(bl,bh,55).
solution(bl,cc,56).
solution(bl,ls,57).
solution(bl,pg,58).
solution(bl,ps,59).
solution(bl,st,60).

solution(bf,pc,61).
solution(bf,bh,62).
solution(bf,cc,63).
solution(bf,ls,64).
solution(bf,pg,65).
solution(bf,ps,66).
solution(bf,st,67).

solution(vr,pc,68).
solution(vr,bh,69).
solution(vr,cc,70).
solution(vr,ls,71).
solution(vr,pg,72).
solution(vr,ps,73).
solution(vr,st,74).

solution(vl,pc,75).
solution(vl,bh,76).
solution(vl,cc,77).
solution(vl,ls,78).
solution(vl,pg,79).
solution(vl,ps,80).
solution(vl,st,81).

solution(vf,pc,82).
solution(vf,bh,83).
solution(vf,cc,84).
solution(vf,ls,85).
solution(vf,pg,86).
solution(vf,ps,87).
solution(vf,st,88).

solution(byr,pc,89).
solution(byr,bh,90).
solution(byr,cc,91).
solution(byr,ls,92).
solution(byr,pg,93).
solution(byr,ps,94).
solution(byr,st,95).

solution(byl,pc,96).
solution(byl,bh,97).
solution(byl,cc,98).
solution(byl,ls,99).
solution(byl,pg,100).
solution(byl,ps,101).
solution(byl,st,102).

solution(byf,pc,103).
solution(byf,bh,104).
solution(byf,cc,105).
solution(byf,ls,106).
solution(byf,pg,107).
solution(byf,ps,108).
solution(byf,st,109).

solution(dr,pc,110).
solution(dr,bh,111).
solution(dr,cc,112).
solution(dr,ls,113).
solution(dr,pg,114).
solution(dr,ps,115).
solution(dr,st,116).

solution(dl,pc,117).
solution(dl,bh,118).
solution(dl,cc,119).
solution(dl,ls,120).
solution(dl,pg,121).
solution(dl,ps,122).
solution(dl,st,123).

solution(df,pc,124).
solution(df,bh,125).
solution(df,cc,126).
solution(df,ls,127).
solution(df,pg,128).
solution(df,ps,129).
solution(df,st,130).

solution(per,pc,131).
solution(per,bh,132).
solution(per,cc,133).
solution(per,ls,134).
solution(per,pg,135).
solution(per,ps,136).
solution(per,st,137).

solution(pel,pc,138).
solution(pel,bh,139).
solution(pel,cc,140).
solution(pel,ls,141).
solution(pel,pg,142).
solution(pel,ps,143).
solution(pel,st,144).

solution(pef,pc,145).
solution(pef,bh,146).
solution(pef,cc,147).
solution(pef,ls,148).
solution(pef,pg,149).
solution(pef,ps,150).
solution(pef,st,151).

solution(por,pc,152).
solution(por,bh,153).
solution(por,cc,154).
solution(por,ls,155).
solution(por,pg,156).
solution(por,ps,157).
solution(por,st,158).

solution(pol,pc,159).
solution(pol,bh,160).
solution(pol,cc,161).
solution(pol,ls,162).
solution(pol,pg,163).
solution(pol,ps,164).
solution(pol,st,165).

solution(pof,pc,166).
solution(pof,bh,167).
solution(pof,cc,168).
solution(pof,ls,169).
solution(pof,pg,170).
solution(pof,ps,171).
solution(pof,st,172).

status(OB,DIR,RS,S):- obstacle(OB,DIR,X),roadsign(RS,Y),solution(X,Y,S).








