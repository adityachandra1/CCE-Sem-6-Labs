BEGIN {
packet[packet_id]=0;
Aggergate_Throughput=0;
count=0;
Average_Throughput=0;
Packet_Throughput=0;
packet_count=0;
}

{

   action = $1;
   time = $2;
   type = $21;
   pktsize = $28;
   packet_id = $19;

 if(type == "6" && $28 > 5)  #type==6; 6 means TCP packet  17 means UDP packet
   {

   if ( packet[packet_id] == 0)
      {
         packet[packet_id] = 1;
         size[packet_id]=$28;
         packet_count=packet_count+1;
         #printf("packet_id=%d\t Packet_count=%d \n",packet_id,packet_count);
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

    for ( packet_id = 0; packet_id <= packet_count; packet_id++ )

    {
       start = start_time[packet_id];
       end = end_time[packet_id];
       delay = end - start;
       

       if(delay >0.000000 )
       {
	 
         Packet_Throughput=(size[packet_id]*8)/delay;
         Aggergate_Throughput=Aggergate_Throughput+Packet_Throughput;
         count=count+1;
       }
     #printf("packet_id=%d\t size=%f\t delay=%f \n",packet_id,size[packet_id],delay);
    }

     #printf("%f \n", count);
     Average_Throughput=(Aggergate_Throughput/count);
     printf("\nAverage_Throughput=%f bits/second \n\n",Average_Throughput);
 
}




