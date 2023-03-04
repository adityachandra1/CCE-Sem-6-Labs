BEGIN {
packet[packet_id]=0;
Packet_count = 0;
Aggergate_delay=0;
count1=0;
Average_delay=0;
count=0;
}

{
   action = $1;
   time = $2;
   type = $21;
   pktsize = $28;
   packet_id = $19;

 if(type == "6") #type==6; 6 means TCP packet  17 means UDP packet
   {

   if ( packet[packet_id] == 0 )
      {
        packet[packet_id] = 1;
        Packet_count=Packet_count+1;
      }


   if ( start_time[packet_id] == 0 ) 
        start_time[packet_id] = time;

   if (  action != "d" )
     {

      if ( action == "r" )
         {
         end_time[packet_id] = time;
         }
     }


   }

}
END {

    for ( packet_id = 0; packet_id <= Packet_count; packet_id++ )

    {
       start = start_time[packet_id];
       end = end_time[packet_id];
       delay = end - start;
       #printf("%f \n", delay);
       if(delay >0.000000)
       {
         Aggergate_delay=Aggergate_delay+delay;
         count=count+1;
         Average_delay=(Aggergate_delay/count);
         printf("%f\t %f\n", end, Average_delay);
       }
   }
}




