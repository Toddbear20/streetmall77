<template>
    <div>
        <Number
            label="Orderid"
            v-model="value.orderid"
            :editMode="editMode"
        />
        <String
            label="Userid"
            v-model="value.userid"
            :editMode="editMode"
        />
        <Number
            label="Productid"
            v-model="value.productid"
            :editMode="editMode"
        />
        <Number
            label="Qty"
            v-model="value.qty"
            :editMode="editMode"
        />
        <String
            label="Status"
            v-model="value.status"
            :editMode="editMode"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Delivery',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "deliveries",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
