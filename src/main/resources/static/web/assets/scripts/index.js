setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
            featuredEp: [],
            featuredAr: [],
            isLoading: false
        }
    },
    created() {
        axios.get(`/api/episodes/featured`)
        .then(res => {
            this.featuredEp = res.data.sort((a, b) => b.id - a.id)
        }).catch(err => console.log(err))
        axios.get(`/api/archives/featured`)
        .then(res => {
            this.featuredAr = res.data
        }).catch(err => console.log(err))
    },
    methods: {
    },
    computed: {
    }
}).mount("#app")
},1000)